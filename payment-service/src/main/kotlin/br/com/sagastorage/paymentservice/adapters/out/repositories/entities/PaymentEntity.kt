package br.com.sagastorage.paymentservice.adapters.out.repositories.entities

import br.com.sagastorage.paymentservice.application.core.domain.Payment
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity(name = "payment")
data class PaymentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val userId: Long,
    val saleId: Long,
    val value: BigDecimal,
) {

    companion object {
        fun Payment.toEntity() = PaymentEntity(
            id = this.id!!,
            userId = this.userId,
            saleId = this.saleId,
            value = this.value
        )
    }
}
