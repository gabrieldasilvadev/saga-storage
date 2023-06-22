package br.com.sagastorage.inventoryservice.application.core.domain.services.implementations

import br.com.sagastorage.inventoryservice.application.core.domain.Sale
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.inventoryservice.application.core.domain.services.SaleDomainService
import br.com.sagastorage.inventoryservice.application.ports.out.SendUpdatedInventoryOutputPort

class SaleDomainServiceImpl(
    private val sendUpdatedInventoryOutputPort: SendUpdatedInventoryOutputPort
) : SaleDomainService {
    override fun updateInventory(sale: Sale, saleEvent: SaleEvent) {
        sendUpdatedInventoryOutputPort.send(sale, saleEvent)
    }
}