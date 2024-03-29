package br.com.sagastorage.inventoryservice.adapters.out

import br.com.sagastorage.inventoryservice.adapters.out.kafka.messages.SaleMessage
import br.com.sagastorage.inventoryservice.adapters.out.kafka.topics.Topic
import br.com.sagastorage.inventoryservice.application.core.domain.Sale
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.inventoryservice.application.ports.out.SendToKafkaOutputPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class SendToKafkaAdapter(
    private val kafkaTemplate: KafkaTemplate<String, SaleMessage>
): SendToKafkaOutputPort {
    override fun send(sale: Sale, saleEvent: SaleEvent) {
        val saleMessage = SaleMessage(sale, saleEvent)

        kafkaTemplate.send(Topic.TP_SAGA_SALE.getTopicName(), saleMessage)
    }
}