package br.com.sagastorage.saleservice.config.kafka;

import br.com.sagastorage.saleservice.adapters.out.messages.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializer implements Serializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, SaleMessage selaMessage) {
        try {
            if (selaMessage == null) {
                return null;
            }
            return objectMapper.writeValueAsBytes(selaMessage);
        } catch (Exception e) {
            throw new SerializationException("Error serializing SaleMessage to byte[]", e);
        }
    }
}
