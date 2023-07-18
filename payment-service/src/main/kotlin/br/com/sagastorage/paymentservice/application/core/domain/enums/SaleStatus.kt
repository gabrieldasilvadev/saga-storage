package br.com.sagastorage.paymentservice.application.core.domain.enums

enum class SaleStatus(private val statusId: Int) {
    PENDING(1), APPROVED(2), REJECTED(3);


    fun getStatus(): Int {
        return statusId
    }

    companion object {
        fun toEnum(statusId: Int): SaleStatus {
            for (saleStatus in values()) {
                if (saleStatus.statusId == statusId) {
                    return saleStatus
                }
            }
            throw IllegalArgumentException("Invalid SaleStatus statusId: $statusId")
        }
    }
}