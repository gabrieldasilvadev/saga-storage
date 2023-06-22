package br.com.sagastorage.inventoryservice.adapters.out.repositories

import br.com.sagastorage.inventoryservice.adapters.out.repositories.entities.InventoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface InventoryRepository : JpaRepository<InventoryEntity, Long> {
    fun findByProductId(productId: Long): InventoryEntity?
}