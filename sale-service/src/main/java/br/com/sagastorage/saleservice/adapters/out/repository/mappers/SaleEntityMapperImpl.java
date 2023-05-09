package br.com.sagastorage.saleservice.adapters.out.repository.mappers;

import br.com.sagastorage.saleservice.adapters.out.repository.entities.SaleEntity;
import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleStatus;
import org.springframework.stereotype.Component;

@Component
public class SaleEntityMapperImpl implements SaleEntityMapper {

    @Override
    public SaleEntity toEntity(Sale sale) {
        return SaleEntity.builder()
                .id(sale.getId())
                .productId(sale.getProductId())
                .userId(sale.getUserId())
                .value(sale.getValue())
                .statusId(sale.getStatus().getStatusId())
                .quantity(sale.getQuantity())
                .build();
    }

    @Override
    public Sale toDomain(SaleEntity saleEntity) {
        return Sale.Builder.builder()
                .id(saleEntity.getId())
                .productId(saleEntity.getProductId())
                .userId(saleEntity.getUserId())
                .value(saleEntity.getValue())
                .status(SaleStatus.toEnum(saleEntity.getStatusId()))
                .quantity(saleEntity.getQuantity())
                .build();
    }
}
