package br.com.sagastorage.inventoryservice.adapters.out.repositories.entities

import br.com.sagastorage.inventoryservice.application.core.domain.Inventory
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "inventory")
data class InventoryEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val productId: Long,
    var quantity: Int
) {

    companion object {
        fun InventoryEntity.toDomain() = Inventory (
            id = this.id,
            productId = this.productId,
            quantity = this.quantity
        )

        fun Inventory.toEntity() = InventoryEntity(
            id = this.id,
            productId = this.productId,
            quantity = this.quantity
        )
    }
}
