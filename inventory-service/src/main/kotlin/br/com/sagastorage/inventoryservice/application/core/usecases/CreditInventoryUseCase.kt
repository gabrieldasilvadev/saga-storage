package br.com.sagastorage.inventoryservice.application.core.usecases

import br.com.sagastorage.inventoryservice.application.core.domain.Sale
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.inventoryservice.application.ports.`in`.CreditInventoryInputPort
import br.com.sagastorage.inventoryservice.application.ports.`in`.FindInventoryByProductIdInputPort
import br.com.sagastorage.inventoryservice.application.ports.out.SendToKafkaOutputPort
import br.com.sagastorage.inventoryservice.application.ports.out.UpdateInventoryOutputPort

class CreditInventoryUseCase(
    private val findInventoryByProductIdInputPort: FindInventoryByProductIdInputPort,
    private val updateInventoryOutputPort: UpdateInventoryOutputPort,
    private val sendToKafkaOutputPort: SendToKafkaOutputPort
) : CreditInventoryInputPort {

    override fun credit(sale: Sale) {
        val inventory = findInventoryByProductIdInputPort.find(sale.productId)
        inventory.debitQuantity(sale.quantity)
        updateInventoryOutputPort.update(inventory)
        sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY)
    }
}