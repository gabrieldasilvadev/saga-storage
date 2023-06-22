package br.com.sagastorage.inventoryservice.adapters.out.kafka.messages

import br.com.sagastorage.inventoryservice.application.core.domain.Sale
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent

data class SaleMessage(
    val sale: Sale,
    val event: SaleEvent
)
