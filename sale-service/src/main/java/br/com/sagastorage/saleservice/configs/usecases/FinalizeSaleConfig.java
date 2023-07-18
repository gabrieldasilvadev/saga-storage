package br.com.sagastorage.saleservice.configs.usecases;

import br.com.sagastorage.saleservice.adapters.out.SaveSaleAdapter;
import br.com.sagastorage.saleservice.application.core.usacases.FinalizeSaleUseCase;
import br.com.sagastorage.saleservice.application.core.usacases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
