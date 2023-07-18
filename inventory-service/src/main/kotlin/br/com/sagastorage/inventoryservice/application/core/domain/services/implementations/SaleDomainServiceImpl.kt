package br.com.sagastorage.inventoryservice.application.core.domain.services.implementations

import br.com.sagastorage.inventoryservice.application.core.domain.Sale
import br.com.sagastorage.inventoryservice.application.core.domain.enums.SaleEvent
import br.com.sagastorage.inventoryservice.application.core.domain.services.SaleDomainService
import br.com.sagastorage.inventoryservice.application.ports.out.SendToKafkaOutputPort

class SaleDomainServiceImpl(
    private val sendToKafkaOutputPort: SendToKafkaOutputPort
) : SaleDomainService {
    override fun updateInventory(sale: Sale, saleEvent: SaleEvent) {
        sendToKafkaOutputPort.send(sale, saleEvent)
    }
}