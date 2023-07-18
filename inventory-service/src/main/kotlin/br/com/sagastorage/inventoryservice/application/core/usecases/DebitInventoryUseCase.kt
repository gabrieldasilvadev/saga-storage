package br.com.sagastorage.inventoryservice.application.core.usecases

import br.com.sagastorage.inventoryservice.application.core.domain.Sale
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.inventoryservice.application.core.domain.services.InventoryDomainService
import br.com.sagastorage.inventoryservice.application.core.domain.services.SaleDomainService
import br.com.sagastorage.inventoryservice.application.ports.`in`.DebitInventoryInputPort
import br.com.sagastorage.inventoryservice.application.ports.`in`.FindInventoryByProductIdInputPort
import br.com.sagastorage.inventoryservice.application.ports.out.SendToKafkaOutputPort
import org.slf4j.LoggerFactory

class DebitInventoryUseCase(
    private val findInventoryByProductIdInputPort: FindInventoryByProductIdInputPort,
    private val inventoryDomainService: InventoryDomainService,
    private val saleDomainService: SaleDomainService,
    private val sendToKafkaOutputPort: SendToKafkaOutputPort
): DebitInventoryInputPort {

    val logger = LoggerFactory.getLogger(DebitInventoryUseCase::class.java)

    override fun debit(sale: Sale) {
        runCatching {
            findInventoryByProductIdInputPort.find(sale.productId)
        }.onSuccess { inventory ->
            inventory.debitQuantity(sale.quantity)
            inventoryDomainService.update(inventory)
            saleDomainService.updateInventory(sale, SaleEvent.UPDATED_INVENTORY)
        }.onFailure {

            when (it) {
                is IllegalArgumentException -> throw RuntimeException("Stock Insufficient for product ${sale.productId}")
                else -> {
                    logger.error("Error on debit inventory ${it.message}")
                    sendToKafkaOutputPort.send(sale, SaleEvent.FAILED_PAYMENT)
                }
            }
        }
    }
}
