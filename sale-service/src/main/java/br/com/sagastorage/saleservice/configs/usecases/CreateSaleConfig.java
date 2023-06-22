package br.com.sagastorage.saleservice.configs.usecases;

import br.com.sagastorage.saleservice.adapters.out.SaveSaleAdapter;
import br.com.sagastorage.saleservice.adapters.out.SendCreatedSaleAdapter;
import br.com.sagastorage.saleservice.application.core.usacases.CreateSaleUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUsecase createSaleUsecase(
            SaveSaleAdapter saveSaleAdapter,
            SendCreatedSaleAdapter sendCreatedSaleAdapter
    ) {
        return new CreateSaleUsecase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}
