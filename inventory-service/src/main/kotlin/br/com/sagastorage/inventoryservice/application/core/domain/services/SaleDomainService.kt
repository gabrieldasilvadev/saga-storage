package br.com.sagastorage.inventoryservice.application.core.domain.services

import br.com.sagastorage.inventoryservice.application.core.domain.Sale
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent

interface SaleDomainService {
    fun updateInventory(sale: Sale, saleEvent: SaleEvent)
}