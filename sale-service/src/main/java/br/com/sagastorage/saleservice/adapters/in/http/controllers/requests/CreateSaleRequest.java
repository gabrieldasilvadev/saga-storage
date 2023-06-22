package br.com.sagastorage.saleservice.adapters.in.http.controllers.requests;

import br.com.sagastorage.saleservice.application.core.domain.Sale;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record CreateSaleRequest(
        @NotNull
        Long userId,
        @NotNull
        Long productId,
        @NotNull
        @Min(1)
        Integer quantity,
        @NotNull
        @DecimalMin(value = "10.00")
        BigDecimal value
) {
        public Sale toDomain() {
                return Sale.Builder.builder()
                        .userId(userId())
                        .productId(productId())
                        .quantity(quantity())
                        .value(value())
                        .build();
        }
}
