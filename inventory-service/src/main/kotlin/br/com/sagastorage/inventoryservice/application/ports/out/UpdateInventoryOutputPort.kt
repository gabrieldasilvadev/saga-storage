package br.com.sagastorage.inventoryservice.application.ports.out

import br.com.sagastorage.inventoryservice.application.core.domain.Inventory

interface UpdateInventoryOutputPort {
    fun update(inventory: Inventory)
}