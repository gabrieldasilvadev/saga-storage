package br.com.sagastorage.paymentservice.configs.usecases

import br.com.sagastorage.paymentservice.adapters.out.FindUserByIdAdapter
import br.com.sagastorage.paymentservice.application.core.usecases.FindUserByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindUserByIdConfig {

    @Bean
    fun findUserByIdUseCase(findUserByIdAdapter: FindUserByIdAdapter) = FindUserByIdUseCase(findUserByIdAdapter)

}
