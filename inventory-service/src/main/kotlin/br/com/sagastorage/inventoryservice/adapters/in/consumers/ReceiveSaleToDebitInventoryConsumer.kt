package br.com.sagastorage.inventoryservice.adapters.`in`.consumers

import br.com.sagastorage.inventoryservice.adapters.out.kafka.messages.SaleMessage
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.inventoryservice.application.ports.`in`.DebitInventoryInputPort
import br.com.sagastorage.inventoryservice.customs.listeners.ReceiveSaleToDebitInventoryListener
import org.springframework.stereotype.Component

@Component
class ReceiveSaleToDebitInventoryConsumer(
    private val debitInventoryInputPort: DebitInventoryInputPort
) {
    @ReceiveSaleToDebitInventoryListener
    fun receive(saleMessage: SaleMessage) {
        if(SaleEvent.CREATED_SALE == saleMessage.event) {
            println("Sale created. Debiting inventory...")
            debitInventoryInputPort.debit(saleMessage.sale)
            println("End of debit inventory.")
        }
    }
}