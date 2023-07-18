package br.com.sagastorage.saleservice.configs.kafka;

import br.com.sagastorage.saleservice.adapters.out.kafka.messages.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;

public class CustomDeserializer implements Deserializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SaleMessage deserialize(String topic, byte[] data) {
        try {
            if (data == null) {
                return null;
            } else {
                return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), SaleMessage.class);
            }
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to SaleMessage");
        }
    }
}
