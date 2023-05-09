package br.com.sagastorage.saleservice.adapters.out.repository.mappers;

import br.com.sagastorage.saleservice.adapters.out.repository.entities.SaleEntity;
import br.com.sagastorage.saleservice.application.core.domain.Sale;

public interface SaleEntityMapper {

    SaleEntity toEntity(Sale sale);
    Sale toDomain(SaleEntity saleEntity);
}
