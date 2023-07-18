package br.com.sagastorage.inventoryservice.application.ports.`in`

import br.com.sagastorage.inventoryservice.application.core.domain.Sale

interface CreditInventoryInputPort {
    fun credit(sale: Sale)
}