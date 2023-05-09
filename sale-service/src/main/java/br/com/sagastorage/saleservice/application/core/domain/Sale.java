package br.com.sagastorage.saleservice.application.core.domain;

import br.com.sagastorage.saleservice.application.core.domain.enums.SaleStatus;
import java.math.BigDecimal;

public class Sale {

    private Long id;
    private Long productId;
    private Long userId;
    private BigDecimal value;
    private SaleStatus status;
    private Integer quantity;

    private Sale(Builder builder) {
        id = builder.id;
        productId = builder.productId;
        userId = builder.userId;
        value = builder.value;
        status = builder.status;
        quantity = builder.quantity;
    }

    public static final class Builder {
        private Long id;
        private Long productId;
        private Long userId;
        private BigDecimal value;
        private SaleStatus status;
        private Integer quantity;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder productId(Long val) {
            productId = val;
            return this;
        }

        public Builder userId(Long val) {
            userId = val;
            return this;
        }

        public Builder value(BigDecimal val) {
            value = val;
            return this;
        }

        public Builder status(SaleStatus val) {
            status = val;
            return this;
        }

        public Builder quantity(Integer val) {
            quantity = val;
            return this;
        }

        public Sale build() {
            return new Sale(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getUserId() {
        return userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
