package br.com.sagastorage.paymentservice.application.ports.out

import br.com.sagastorage.paymentservice.application.core.domain.User

interface UpdateUserOutputPort {
    fun update(user: User)
}