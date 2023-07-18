package br.com.sagastorage.inventoryservice.configs.usecases

import br.com.sagastorage.inventoryservice.adapters.out.SendToKafkaAdapter
import br.com.sagastorage.inventoryservice.adapters.out.UpdateInventoryAdapter
import br.com.sagastorage.inventoryservice.application.core.usecases.CreditInventoryUseCase
import br.com.sagastorage.inventoryservice.application.core.usecases.FindInventoryByProductIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CreditInventoryConfig {

    @Bean
    fun creditInventoryUseCase(
        findInventoryByProductIdUseCase: FindInventoryByProductIdUseCase,
        updateInventoryAdapter: UpdateInventoryAdapter,
        sendToKafkaAdapter: SendToKafkaAdapter
    ): CreditInventoryUseCase {
        return CreditInventoryUseCase(
            findInventoryByProductIdUseCase,
            updateInventoryAdapter,
            sendToKafkaAdapter
        )
    }
}