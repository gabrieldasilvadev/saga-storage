package br.com.sagastorage.paymentservice.application.core.usecases

import br.com.sagastorage.paymentservice.application.core.domain.Payment
import br.com.sagastorage.paymentservice.application.core.domain.Sale
import br.com.sagastorage.paymentservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.paymentservice.application.ports.`in`.FindUserByIdInputPort
import br.com.sagastorage.paymentservice.application.ports.`in`.SalePaymentInputPort
import br.com.sagastorage.paymentservice.application.ports.out.SavePaymentOutputPort
import br.com.sagastorage.paymentservice.application.ports.out.SendToKafkaOutputPort
import br.com.sagastorage.paymentservice.application.ports.out.UpdateUserOutputPort
import org.slf4j.LoggerFactory

class SalePaymentUseCase(
    private val findUserByIdInputPort: FindUserByIdInputPort,
    private val updateUserOutputPort: UpdateUserOutputPort,
    private val savePaymentOutputPort: SavePaymentOutputPort,
    private val sendToKafkaOutputPort: SendToKafkaOutputPort
) : SalePaymentInputPort {

    val logger = LoggerFactory.getLogger(SalePaymentUseCase::class.java)

    override fun payment(sale: Sale) {
        try {
            val user = findUserByIdInputPort.find(sale.userId)!!

            if (user.balance < sale.value) {
                throw RuntimeException("Insufficient balance")
            }
            user.debitBalance(sale.value)
            updateUserOutputPort.update(user)
            savePaymentOutputPort.save(buildPayment(sale))
            sendToKafkaOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT)
        } catch (e: Exception) {
            logger.error("Error on payment ${e.message}")
            sendToKafkaOutputPort.send(sale, SaleEvent.FAILED_PAYMENT)
        }
    }

    private fun buildPayment(sale: Sale): Payment {
        return Payment(
            id = null,
            userId = sale.userId,
            saleId = sale.id,
            value = sale.value
        )
    }
}