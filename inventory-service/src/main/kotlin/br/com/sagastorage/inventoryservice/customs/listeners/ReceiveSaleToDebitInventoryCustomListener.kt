package br.com.sagastorage.inventoryservice.customs.listeners

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import org.springframework.kafka.annotation.KafkaListener

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener(
    topics = ["tp-saga-sale"],
    groupId = "inventory-debit",
)
annotation class ReceiveSaleToDebitInventoryListener