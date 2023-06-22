package br.com.sagastorage.saleservice.application.core.usacases;

import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleEvent;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleStatus;
import br.com.sagastorage.saleservice.application.ports.in.CreateSaleInputPort;
import br.com.sagastorage.saleservice.application.ports.out.SaveSaleOutputPort;
import br.com.sagastorage.saleservice.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUsecase implements CreateSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public CreateSaleUsecase(SaveSaleOutputPort saveSaleOutputPort, SendCreatedSaleOutputPort sendCreatedSaleOutputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }

    @Override
    public void create(Sale sale) {
        Sale.Builder.builder()
                .status(SaleStatus.PENDING)
                .build();

        var saleResponse = saveSaleOutputPort.save(sale);
        sendCreatedSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
