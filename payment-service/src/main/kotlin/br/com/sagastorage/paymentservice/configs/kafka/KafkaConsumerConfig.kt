package br.com.sagastorage.paymentservice.configs.kafka

import br.com.sagastorage.paymentservice.adapters.out.message.SaleMessage
import org.apache.kafka.clients.consumer.ConsumerConfig.*
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
@EnableKafka
class KafkaConsumerConfig{

    @Bean
    fun consumerFactory(): ConsumerFactory<String, SaleMessage> {
        val props = HashMap<String, Any>()
        props[BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        props[GROUP_ID_CONFIG] = "payment"
        props[KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[VALUE_DESERIALIZER_CLASS_CONFIG] = CustomDeserializer::class.java
        props[AUTO_OFFSET_RESET_CONFIG] = "earliest"
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConsumerFactory<String, SaleMessage> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, SaleMessage> = ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = consumerFactory()
        return consumerFactory()
    }
}