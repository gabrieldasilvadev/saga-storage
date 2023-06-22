package br.com.sagastorage.saleservice.application.ports.in;

import br.com.sagastorage.saleservice.application.core.domain.Sale;

public interface CreateSaleInputPort {
    void create(Sale sale);
}
