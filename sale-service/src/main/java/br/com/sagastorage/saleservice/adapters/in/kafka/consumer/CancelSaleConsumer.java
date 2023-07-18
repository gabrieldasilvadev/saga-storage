package br.com.sagastorage.saleservice.adapters.in.kafka.consumer;

import br.com.sagastorage.saleservice.adapters.out.kafka.messages.SaleMessage;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleEvent;
import br.com.sagastorage.saleservice.application.ports.in.CancelSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CancelSaleConsumer {

    private final CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.saleEvent())) {
            log.info("Canceling Sale...: {}", saleMessage);
            cancelSaleInputPort.cancel(saleMessage.sale());
            log.info("Sale canceled: {}", saleMessage);
        }
    }
}
