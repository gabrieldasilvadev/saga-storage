package br.com.sagastorage.inventoryservice.adapters.out

import br.com.sagastorage.inventoryservice.adapters.out.repositories.InventoryRepository
import br.com.sagastorage.inventoryservice.adapters.out.repositories.entities.InventoryEntity.Companion.toDomain
import br.com.sagastorage.inventoryservice.application.core.domain.Inventory
import br.com.sagastorage.inventoryservice.application.ports.`in`.FindInventoryByProductIdInputPort
import br.com.sagastorage.inventoryservice.application.ports.out.FindInventoryByProductIdOutputPort
import org.springframework.stereotype.Component

@Component
class FindInventoryByProductIdAdapter(
    private val inventoryRepository: InventoryRepository
) : FindInventoryByProductIdOutputPort {
    override fun find(productId: Long): Inventory? {
        val inventoryEntity = inventoryRepository.findByProductId(productId)

        return inventoryEntity?.toDomain()
    }
}