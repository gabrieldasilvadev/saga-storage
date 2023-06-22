package br.com.sagastorage.inventoryservice.application.core.domain

class Inventory(
    val id: Long,
    val productId: Long,
    var quantity: Int
) {
    fun debitQuantity(quantity: Int) {
        if (this.quantity < quantity) {
            throw IllegalArgumentException("Invalid quantity")
        }
        this.quantity -= quantity
    }
}
