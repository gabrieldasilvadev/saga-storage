package br.com.sagastorage.saleservice.application.ports.in;

import br.com.sagastorage.saleservice.application.core.domain.Sale;

public interface FindSaleByIdInputPort {
    Sale find(final Long id);
}
