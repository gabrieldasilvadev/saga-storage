package br.com.sagastorage.paymentservice.application.core.domain

import br.com.sagastorage.paymentservice.application.core.domain.enums.SaleStatus
import java.math.BigDecimal

data class Sale(
    val id: Long,
    val productId: Long,
    val userId: Long,
    val value: BigDecimal,
    val saleStatus: SaleStatus,
    var quantity: Int
) {
}