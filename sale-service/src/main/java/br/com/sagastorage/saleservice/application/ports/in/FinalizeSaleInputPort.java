package br.com.sagastorage.saleservice.application.ports.in;

import br.com.sagastorage.saleservice.application.core.domain.Sale;

public interface FinalizeSaleInputPort {
    void finalize(Sale sale);
}
