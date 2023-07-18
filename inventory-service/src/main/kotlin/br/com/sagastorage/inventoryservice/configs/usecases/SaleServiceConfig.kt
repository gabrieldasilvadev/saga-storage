package br.com.sagastorage.inventoryservice.configs.usecases

import br.com.sagastorage.inventoryservice.adapters.out.SendToKafkaAdapter
import br.com.sagastorage.inventoryservice.application.core.domain.services.implementations.SaleDomainServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SaleServiceConfig {

    @Bean
    fun saleService(
        sendToKafkaAdapter: SendToKafkaAdapter
    ): SaleDomainServiceImpl {
        return SaleDomainServiceImpl(sendToKafkaAdapter)
    }
}