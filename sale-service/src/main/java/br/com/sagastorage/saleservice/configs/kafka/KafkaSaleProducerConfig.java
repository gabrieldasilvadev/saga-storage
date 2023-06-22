package br.com.sagastorage.saleservice.configs.kafka;

import br.com.sagastorage.saleservice.adapters.out.kafka.groups.GroupId;
import br.com.sagastorage.saleservice.adapters.out.kafka.messages.SaleMessage;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


import static org.apache.kafka.clients.CommonClientConfigs.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

@RequiredArgsConstructor
@Configuration
public class KafkaSaleProducerConfig {

    private final KafkaProperties properties;

    @Bean
    public ProducerFactory<String, SaleMessage> producerFactory() {

        return new DefaultKafkaProducerFactory<>(configs());
    }

    @Bean
    public KafkaTemplate<String, SaleMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    private Map<String, Object> configs() {
        return new HashMap<String, Object>(
                Map.of(
                        BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers(),
                        GROUP_ID_CONFIG, GroupId.SALE.getGroupId(),
                        KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                        VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class
                )
        );
    }
}
