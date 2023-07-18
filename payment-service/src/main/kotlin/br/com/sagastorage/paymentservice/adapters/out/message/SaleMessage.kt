package br.com.sagastorage.paymentservice.adapters.out.message

import br.com.sagastorage.paymentservice.application.core.domain.Sale
import br.com.sagastorage.paymentservice.application.core.domain.enums.SaleEvent

data class SaleMessage(
    val sale: Sale,
    val saleEvent: SaleEvent
)
