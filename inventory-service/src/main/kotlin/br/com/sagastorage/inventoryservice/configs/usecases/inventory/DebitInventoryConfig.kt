package br.com.sagastorage.inventoryservice.configs.usecases.inventory

import br.com.sagastorage.inventoryservice.application.core.domain.services.implementations.InventoryDomainServiceImpl
import br.com.sagastorage.inventoryservice.application.core.domain.services.implementations.SaleDomainServiceImpl
import br.com.sagastorage.inventoryservice.application.core.usecases.DebitInventoryUseCase
import br.com.sagastorage.inventoryservice.application.core.usecases.FindInventoryByProductIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DebitInventoryConfig {

    @Bean
    fun debitInventoryUseCase(
        findInventoryByProductIdUseCase: FindInventoryByProductIdUseCase,
        inventoryService: InventoryDomainServiceImpl,
        saleService: SaleDomainServiceImpl
    ): DebitInventoryUseCase {
        return DebitInventoryUseCase(findInventoryByProductIdUseCase, inventoryService, saleService)
    }
}