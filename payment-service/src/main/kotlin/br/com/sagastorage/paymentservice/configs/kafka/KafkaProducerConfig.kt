package br.com.sagastorage.paymentservice.configs.kafka

import br.com.sagastorage.paymentservice.adapters.out.message.SaleMessage
import org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG
import org.apache.kafka.clients.producer.ProducerConfig.*
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
@EnableKafka
class KafkaProducerConfig{

    @Bean
    fun producerFactory(): ProducerFactory<String, SaleMessage> {
        val configProps = HashMap<String, Any>()
        configProps[BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        configProps[GROUP_ID_CONFIG] = "payment"
        configProps[KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[VALUE_SERIALIZER_CLASS_CONFIG] = CustomSerializer::class.java
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, SaleMessage> {
        return KafkaTemplate(producerFactory())
    }
}