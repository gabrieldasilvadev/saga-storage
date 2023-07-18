package br.com.sagastorage.paymentservice.configs.kafka

import br.com.sagastorage.paymentservice.adapters.out.message.SaleMessage
import org.springframework.core.serializer.Serializer
import java.io.OutputStream

class CustomSerializer : Serializer<SaleMessage> {

    override fun serialize(`object`: SaleMessage, outputStream: OutputStream) {
        outputStream.write(`object`.toString().toByteArray())
    }
}