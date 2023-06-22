package br.com.sagastorage.inventoryservice.application.core.domain.services.implementations

import br.com.sagastorage.inventoryservice.application.core.domain.Inventory
import br.com.sagastorage.inventoryservice.application.core.domain.services.InventoryDomainService
import br.com.sagastorage.inventoryservice.application.ports.out.UpdateInventoryOutputPort

class InventoryDomainServiceImpl(
    private val updateInventoryOutputPort: UpdateInventoryOutputPort
) : InventoryDomainService {
    override fun update(inventory: Inventory) {
        updateInventoryOutputPort.update(inventory)
    }
}