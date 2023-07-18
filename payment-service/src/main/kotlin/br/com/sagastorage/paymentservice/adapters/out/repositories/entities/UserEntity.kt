package br.com.sagastorage.paymentservice.adapters.out.repositories.entities

import br.com.sagastorage.paymentservice.application.core.domain.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity(name = "user")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val balance: BigDecimal
) {

    companion object {
        fun UserEntity.toDomain() = User(
            id = this.id,
            name = this.name,
            balance = this.balance
        )

        fun User.toEntity() = UserEntity(
            id = this.id,
            name = this.name,
            balance = this.balance
        )
    }
}
