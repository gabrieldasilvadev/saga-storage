package br.com.sagastorage.paymentservice.adapters.out

import br.com.sagastorage.paymentservice.adapters.out.repositories.PaymentRepository
import br.com.sagastorage.paymentservice.adapters.out.repositories.entities.PaymentEntity.Companion.toEntity
import br.com.sagastorage.paymentservice.application.core.domain.Payment
import br.com.sagastorage.paymentservice.application.ports.out.SavePaymentOutputPort
import org.springframework.stereotype.Service

@Service
class SavePaymentAdapter(
    private val paymentRepository: PaymentRepository
) : SavePaymentOutputPort {
    override fun save(payment: Payment) {
        paymentRepository.save(payment.toEntity())
    }
}