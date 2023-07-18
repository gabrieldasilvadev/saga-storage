package br.com.sagastorage.inventoryservice.adapters.`in`.consumers

import br.com.sagastorage.inventoryservice.adapters.out.kafka.messages.SaleMessage
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.inventoryservice.application.ports.`in`.CreditInventoryInputPort
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveSaleToCreditInventoryConsumer(
    private val creditInventoryInputPort: CreditInventoryInputPort
) {

    val logger = LoggerFactory.getLogger(ReceiveSaleToCreditInventoryConsumer::class.java)

    @KafkaListener(topics = ["tp-saga-sale"], groupId = "inventory-credit")
    fun receive(saleMessage: SaleMessage) {
        if(SaleEvent.FAILED_PAYMENT == saleMessage.event) {
            logger.info("Starting devolution of inventory")
            creditInventoryInputPort.credit(saleMessage.sale)
            logger.info("End devolution of inventory")
        }
    }
}