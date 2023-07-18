package br.com.sagastorage.paymentservice.configs.usecases

import br.com.sagastorage.paymentservice.adapters.out.SavePaymentAdapter
import br.com.sagastorage.paymentservice.adapters.out.SendToKafkaAdapter
import br.com.sagastorage.paymentservice.adapters.out.UpdateUserAdapter
import br.com.sagastorage.paymentservice.application.core.usecases.FindUserByIdUseCase
import br.com.sagastorage.paymentservice.application.core.usecases.SalePaymentUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SalePaymentConfig {

    @Bean
    fun salePaymentUseCase(
        findUserByIdUseCase: FindUserByIdUseCase,
        updateUserAdapter: UpdateUserAdapter,
        savePaymentAdapter: SavePaymentAdapter,
        sendToKafkaAdapter: SendToKafkaAdapter
    ) = SalePaymentUseCase(
        findUserByIdUseCase,
        updateUserAdapter,
        savePaymentAdapter,
        sendToKafkaAdapter
    )
}