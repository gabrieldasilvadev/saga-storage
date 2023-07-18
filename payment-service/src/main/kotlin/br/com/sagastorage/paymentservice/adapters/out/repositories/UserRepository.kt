package br.com.sagastorage.paymentservice.adapters.out.repositories

import br.com.sagastorage.paymentservice.adapters.out.repositories.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
}