package br.com.sagastorage.paymentservice.configs.kafka

import br.com.sagastorage.paymentservice.adapters.out.message.SaleMessage
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer

class CustomDeserializer(
    private val objectMapper: ObjectMapper
) : Deserializer<SaleMessage> {
    override fun deserialize(topic: String?, data: ByteArray?): SaleMessage {
        try {
            return objectMapper.readValue(data, SaleMessage::class.java)
        } catch (e: Exception) {
            throw SerializationException("Error when deserializing byte[] to SaleMessage")
        }
    }
}