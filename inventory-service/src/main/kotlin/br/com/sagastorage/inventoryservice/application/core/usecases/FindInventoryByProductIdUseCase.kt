package br.com.sagastorage.inventoryservice.application.core.usecases

import br.com.sagastorage.inventoryservice.application.core.domain.Inventory
import br.com.sagastorage.inventoryservice.application.ports.`in`.FindInventoryByProductIdInputPort
import br.com.sagastorage.inventoryservice.application.ports.out.FindInventoryByProductIdOutputPort

class FindInventoryByProductIdUseCase(
    private val findInventoryByProductIdOutputPort: FindInventoryByProductIdOutputPort
) : FindInventoryByProductIdInputPort {

    override fun find(productId: Long): Inventory {
        findInventoryByProductIdOutputPort.find(productId)?.let { inventory ->
            return inventory
        } ?: run {
            throw RuntimeException("Inventory not found for product $productId")
        }
    }
}