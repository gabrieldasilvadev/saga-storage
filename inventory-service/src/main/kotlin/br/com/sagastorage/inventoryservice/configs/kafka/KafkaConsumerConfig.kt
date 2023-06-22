package br.com.sagastorage.inventoryservice.configs.kafka

import br.com.sagastorage.inventoryservice.adapters.out.kafka.messages.SaleMessage
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@EnableKafka
@Configuration
class KafkaConsumerConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, SaleMessage> {
        return DefaultKafkaConsumerFactory(configs())
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, SaleMessage> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, SaleMessage>()
        factory.setConsumerFactory(consumerFactory())
        return factory
    }

    private fun configs(): HashMap<String, Any> {
        return hashMapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.bootstrapServers,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to kafkaProperties.consumer.keyDeserializer,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to kafkaProperties.consumer.valueDeserializer,
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest",
        )
    }
}