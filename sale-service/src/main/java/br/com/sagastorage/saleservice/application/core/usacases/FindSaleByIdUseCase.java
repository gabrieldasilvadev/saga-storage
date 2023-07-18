package br.com.sagastorage.saleservice.application.core.usacases;

import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.ports.in.FindSaleByIdInputPort;
import br.com.sagastorage.saleservice.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(final Long id) {
        return findSaleByIdOutputPort
                .find(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));
    }
}
