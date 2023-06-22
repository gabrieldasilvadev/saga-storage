package br.com.sagastorage.saleservice.adapters.in.http.controllers.contracts;

import br.com.sagastorage.saleservice.adapters.in.http.controllers.requests.CreateSaleRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface SaleOperations {

    @PostMapping
    ResponseEntity<?> createSale(@Valid @RequestBody CreateSaleRequest createSaleRequest);
}
