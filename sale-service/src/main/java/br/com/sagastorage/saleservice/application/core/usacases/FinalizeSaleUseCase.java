package br.com.sagastorage.saleservice.application.core.usacases;

import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleStatus;
import br.com.sagastorage.saleservice.application.ports.in.FinalizeSaleInputPort;
import br.com.sagastorage.saleservice.application.ports.in.FindSaleByIdInputPort;
import br.com.sagastorage.saleservice.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public FinalizeSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort, SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void finalize(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutputPort.save(saleResponse);
    }
}
