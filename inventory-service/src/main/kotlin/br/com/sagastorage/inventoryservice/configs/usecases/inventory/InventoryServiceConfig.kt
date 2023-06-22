package br.com.sagastorage.inventoryservice.configs.usecases.inventory

import br.com.sagastorage.inventoryservice.adapters.out.UpdateInventoryAdapter
import br.com.sagastorage.inventoryservice.application.core.domain.services.implementations.InventoryDomainServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InventoryServiceConfig {
    @Bean
    fun inventoryService(updateInventoryAdapter: UpdateInventoryAdapter): InventoryDomainServiceImpl {
        return InventoryDomainServiceImpl(updateInventoryAdapter)
    }
}