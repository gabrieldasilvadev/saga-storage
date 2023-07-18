package br.com.sagastorage.paymentservice.application.ports.out

import br.com.sagastorage.paymentservice.application.core.domain.Sale
import br.com.sagastorage.paymentservice.application.core.domain.enums.SaleEvent

interface SendToKafkaOutputPort {
    fun send(sale: Sale, saleEvent: SaleEvent)
}