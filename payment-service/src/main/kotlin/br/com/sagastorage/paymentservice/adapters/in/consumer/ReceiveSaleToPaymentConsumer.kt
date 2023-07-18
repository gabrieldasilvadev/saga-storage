package br.com.sagastorage.paymentservice.adapters.`in`.consumer

import br.com.sagastorage.paymentservice.adapters.out.message.SaleMessage
import br.com.sagastorage.paymentservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.paymentservice.application.ports.`in`.SalePaymentInputPort
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener

class ReceiveSaleToPaymentConsumer(
    private val salePaymentInputPort: SalePaymentInputPort
) {
    val logger = LoggerFactory.getLogger(ReceiveSaleToPaymentConsumer::class.java)
    @KafkaListener(topics = ["tp-saga-sale"], groupId = "payment")
    fun receive(saleMessage: SaleMessage) {
        if(SaleEvent.UPDATED_INVENTORY == saleMessage.saleEvent) {
            logger.info("Sale updated. Payment...")
            salePaymentInputPort.payment(saleMessage.sale)
            logger.info("End of payment.")
        }
    }
}