package br.com.sagastorage.paymentservice.adapters.out

import br.com.sagastorage.paymentservice.adapters.out.message.SaleMessage
import br.com.sagastorage.paymentservice.application.core.domain.Sale
import br.com.sagastorage.paymentservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.paymentservice.application.ports.out.SendToKafkaOutputPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class SendToKafkaAdapter(
    private val kafkaTemplate: KafkaTemplate<String, SaleMessage>
) : SendToKafkaOutputPort {
    override fun send(sale: Sale, saleEvent: SaleEvent) {
        kafkaTemplate.send("sale", SaleMessage(sale, saleEvent))
        kafkaTemplate.send("tp-saga-sale", SaleMessage(sale, saleEvent))
    }
}