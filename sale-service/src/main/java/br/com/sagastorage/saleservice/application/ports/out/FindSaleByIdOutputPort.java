package br.com.sagastorage.saleservice.application.ports.out;

import br.com.sagastorage.saleservice.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {
    Optional<Sale> find(final Long id);
}
