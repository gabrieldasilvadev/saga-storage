package br.com.sagastorage.paymentservice.application.core.domain.enums

enum class SaleEvent {
    CREATED_SALE,
    UPDATED_INVENTORY,
    VALIDATED_PAYMENT,
    ROLLBACK_INVENTORY,
    FAILED_PAYMENT
}