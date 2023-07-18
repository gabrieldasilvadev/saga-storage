package br.com.sagastorage.paymentservice.application.core.usecases

import br.com.sagastorage.paymentservice.application.core.domain.User
import br.com.sagastorage.paymentservice.application.ports.`in`.FindUserByIdInputPort
import br.com.sagastorage.paymentservice.application.ports.out.FindUserByIdOutputPort

class FindUserByIdUseCase(
    private val findUserByIdOutputPort: FindUserByIdOutputPort
) : FindUserByIdInputPort {

    override fun find(id: Long): User {
        return findUserByIdOutputPort.find(id)
    }
}