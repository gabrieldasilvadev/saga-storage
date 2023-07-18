package br.com.sagastorage.saleservice.application.ports.in;

import br.com.sagastorage.saleservice.application.core.domain.Sale;

public interface CancelSaleInputPort {
    void cancel(Sale sale);
}
