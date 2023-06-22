package br.com.sagastorage.inventoryservice.application.ports.`in`

import br.com.sagastorage.inventoryservice.application.core.domain.Inventory

interface FindInventoryByProductIdInputPort {
    fun find(productId: Long): Inventory
}