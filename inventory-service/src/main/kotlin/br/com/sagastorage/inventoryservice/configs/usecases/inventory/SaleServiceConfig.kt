package br.com.sagastorage.inventoryservice.configs.usecases.inventory

import br.com.sagastorage.inventoryservice.adapters.out.SendUpdatedInventoryAdapter
import br.com.sagastorage.inventoryservice.application.core.domain.services.implementations.SaleDomainServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaleServiceConfig {

    @Bean
    fun saleService(
        sendUpdatedInventoryAdapter: SendUpdatedInventoryAdapter
    ): SaleDomainServiceImpl {
        return SaleDomainServiceImpl(sendUpdatedInventoryAdapter)
    }
}