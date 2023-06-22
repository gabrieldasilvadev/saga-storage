package br.com.sagastorage.inventoryservice.configs.kafka

import br.com.sagastorage.inventoryservice.adapters.out.kafka.messages.SaleMessage
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer

class CustomDeserializer(
    private val objectMapper: ObjectMapper
): Deserializer<SaleMessage> {
    override fun deserialize(topic: String?, data: ByteArray?): SaleMessage {
        return data?.let { objectMapper.readValue(String(it, Charsets.UTF_8), SaleMessage::class.java) } ?: run {
            throw SerializationException("Error when deserializing byte[] to SaleMessage.")
        }
    }
}