package br.com.sagastorage.saleservice.configs.usecases;

import br.com.sagastorage.saleservice.adapters.out.SaveSaleAdapter;
import br.com.sagastorage.saleservice.application.core.usacases.CancelSaleUseCase;
import br.com.sagastorage.saleservice.application.core.usacases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
