package br.com.sagastorage.inventoryservice.configs.kafka

import br.com.sagastorage.inventoryservice.adapters.out.kafka.messages.SaleMessage
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer

class CustomSerializer : Serializer<SaleMessage> {
    private val objectMapper = ObjectMapper()
    override fun serialize(topic: String, saleMessage: SaleMessage?): ByteArray {
        return saleMessage?.let { objectMapper.writeValueAsBytes(it) } ?: run {
            throw SerializationException("Error serializing JSON message.")
        }
    }
}