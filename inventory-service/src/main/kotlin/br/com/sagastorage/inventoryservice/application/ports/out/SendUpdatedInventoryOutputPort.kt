package br.com.sagastorage.inventoryservice.application.ports.out

import br.com.sagastorage.inventoryservice.application.core.domain.Sale
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent

interface SendUpdatedInventoryOutputPort {
    fun send(sale: Sale, saleEvent: SaleEvent)
}