package br.com.sagastorage.paymentservice.adapters.out

import br.com.sagastorage.paymentservice.adapters.out.repositories.UserRepository
import br.com.sagastorage.paymentservice.adapters.out.repositories.entities.UserEntity.Companion.toDomain
import br.com.sagastorage.paymentservice.application.core.domain.User
import br.com.sagastorage.paymentservice.application.ports.out.FindUserByIdOutputPort
import org.springframework.stereotype.Service

@Service
class FindUserByIdAdapter(
    private val userRepository: UserRepository
) : FindUserByIdOutputPort {
    override fun find(id: Long): User {
        val userEntity = userRepository.findById(id)
        return userEntity.get().toDomain()
    }
}