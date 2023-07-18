package br.com.sagastorage.paymentservice.application.core.domain

import java.math.BigDecimal

data class Payment(
    val id: Long?,
    val userId: Long,
    val saleId: Long,
    val value: BigDecimal,
) {
}