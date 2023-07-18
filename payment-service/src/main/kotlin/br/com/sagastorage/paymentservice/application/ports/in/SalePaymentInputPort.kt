package br.com.sagastorage.paymentservice.application.ports.`in`

import br.com.sagastorage.paymentservice.application.core.domain.Sale

interface SalePaymentInputPort {
    fun payment(sale: Sale)
}