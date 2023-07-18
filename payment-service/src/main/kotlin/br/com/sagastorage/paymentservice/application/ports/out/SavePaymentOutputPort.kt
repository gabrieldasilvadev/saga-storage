package br.com.sagastorage.paymentservice.application.ports.out

import br.com.sagastorage.paymentservice.application.core.domain.Payment

interface SavePaymentOutputPort {
    fun save(payment: Payment)
}