package br.com.sagastorage.inventoryservice.adapters.out.kafka.topics

enum class Topic(private val topicName: String) {
    TP_SAGA_SALE("tp-saga-sale");

    fun getTopicName(): String {
        return topicName
    }
}