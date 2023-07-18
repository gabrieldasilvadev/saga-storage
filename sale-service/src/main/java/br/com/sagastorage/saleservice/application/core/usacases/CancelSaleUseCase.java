package br.com.sagastorage.saleservice.application.core.usacases;

import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleStatus;
import br.com.sagastorage.saleservice.application.ports.in.CancelSaleInputPort;
import br.com.sagastorage.saleservice.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdUseCase findSaleByIdUseCase;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(FindSaleByIdUseCase findSaleByIdUseCase, SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdUseCase = findSaleByIdUseCase;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void cancel(Sale sale) {
        var saleResponse = findSaleByIdUseCase.find(sale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutputPort.save(saleResponse);
    }
}
