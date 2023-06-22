package br.com.sagastorage.inventoryservice.adapters.out

import br.com.sagastorage.inventoryservice.adapters.out.repositories.InventoryRepository
import br.com.sagastorage.inventoryservice.adapters.out.repositories.entities.InventoryEntity.Companion.toEntity
import br.com.sagastorage.inventoryservice.application.core.domain.Inventory
import br.com.sagastorage.inventoryservice.application.ports.out.UpdateInventoryOutputPort
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class UpdateInventoryAdapter(
    private val inventoryRepository: InventoryRepository
) : UpdateInventoryOutputPort {
    override fun update(inventory: Inventory) {
        inventoryRepository.save(inventory.toEntity())
    }
}