package br.com.sagastorage.inventoryservice.application.core.domain.services

import br.com.sagastorage.inventoryservice.application.core.domain.Inventory

interface InventoryDomainService {
    fun update(inventory: Inventory)
}