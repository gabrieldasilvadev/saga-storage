package br.com.sagastorage.paymentservice.application.ports.`in`

import br.com.sagastorage.paymentservice.application.core.domain.User

interface FindUserByIdInputPort {

    fun find(id: Long): User?
}