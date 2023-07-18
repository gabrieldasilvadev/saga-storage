package br.com.sagastorage.paymentservice.application.core.domain

import java.math.BigDecimal

data class User(
    val id: Long,
    val name: String,
    var balance: BigDecimal
) {

    fun debitBalance(value: BigDecimal) {
        this.balance = this.balance.subtract(value)
    }
}
