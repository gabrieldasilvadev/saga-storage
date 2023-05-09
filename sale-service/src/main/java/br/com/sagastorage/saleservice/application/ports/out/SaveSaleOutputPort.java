package br.com.sagastorage.saleservice.application.ports.out;

import br.com.sagastorage.saleservice.application.core.domain.Sale;

public interface SaveSaleOutputPort {
    Sale save(Sale sale);
}
