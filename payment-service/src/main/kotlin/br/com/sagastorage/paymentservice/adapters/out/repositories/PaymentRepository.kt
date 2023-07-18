package br.com.sagastorage.paymentservice.adapters.out.repositories

import br.com.sagastorage.paymentservice.adapters.out.repositories.entities.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<PaymentEntity, Long> {
}