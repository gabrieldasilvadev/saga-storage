package br.com.sagastorage.saleservice.adapters.out.messages;

import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleEvent;

public record SaleMessage(
   Sale sale,
   SaleEvent saleEvent
) {}
