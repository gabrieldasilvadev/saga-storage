package br.com.sagastorage.inventoryservice.configs.usecases.inventory

import br.com.sagastorage.inventoryservice.adapters.out.FindInventoryByProductIdAdapter
import br.com.sagastorage.inventoryservice.application.core.usecases.FindInventoryByProductIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindInventoryByProductIdConfig {

    @Bean
    fun findInventoryByProductIdUseCase(
        findInventoryByProductIdAdapter: FindInventoryByProductIdAdapter
    ): FindInventoryByProductIdUseCase {
        return FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter)
    }
}