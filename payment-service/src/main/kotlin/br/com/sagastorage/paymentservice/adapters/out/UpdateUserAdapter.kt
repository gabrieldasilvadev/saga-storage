package br.com.sagastorage.paymentservice.adapters.out

import br.com.sagastorage.paymentservice.adapters.out.repositories.UserRepository
import br.com.sagastorage.paymentservice.adapters.out.repositories.entities.UserEntity.Companion.toEntity
import br.com.sagastorage.paymentservice.application.core.domain.User
import br.com.sagastorage.paymentservice.application.ports.out.UpdateUserOutputPort
import org.springframework.stereotype.Service

@Service
class UpdateUserAdapter(
    private val userRepository: UserRepository
) : UpdateUserOutputPort {
    override fun update(user: User) {
        userRepository.save(user.toEntity())
    }
}
