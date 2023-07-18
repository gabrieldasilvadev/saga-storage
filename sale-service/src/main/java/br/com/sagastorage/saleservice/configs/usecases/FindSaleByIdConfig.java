package br.com.sagastorage.saleservice.configs.usecases;

import br.com.sagastorage.saleservice.adapters.out.FindSaleByIdAdapter;
import br.com.sagastorage.saleservice.application.core.usacases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(
            FindSaleByIdAdapter findSaleByIdAdapter
    ) {
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
