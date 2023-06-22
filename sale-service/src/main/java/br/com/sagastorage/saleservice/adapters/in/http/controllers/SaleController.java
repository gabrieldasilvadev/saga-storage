package br.com.sagastorage.saleservice.adapters.in.http.controllers;

import br.com.sagastorage.saleservice.adapters.in.http.controllers.contracts.SaleOperations;
import br.com.sagastorage.saleservice.adapters.in.http.controllers.requests.CreateSaleRequest;
import br.com.sagastorage.saleservice.application.ports.in.CreateSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController implements SaleOperations {

    private final CreateSaleInputPort createSaleInputPort;

    @Override
    public ResponseEntity<?> createSale(CreateSaleRequest createSaleRequest) {
        log.info("Creating sale: {}", createSaleRequest);
        createSaleInputPort.create(createSaleRequest.toDomain());
        log.info("Sale created: {}", createSaleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
