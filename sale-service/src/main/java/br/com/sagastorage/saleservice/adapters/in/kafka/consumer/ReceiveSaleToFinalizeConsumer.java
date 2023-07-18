package br.com.sagastorage.saleservice.adapters.in.kafka.consumer;

import br.com.sagastorage.saleservice.adapters.out.kafka.messages.SaleMessage;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleEvent;
import br.com.sagastorage.saleservice.application.ports.in.FinalizeSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToFinalizeConsumer {

    private final FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-finalize")
    public void consume(SaleMessage saleMessage) {
        if(SaleEvent.VALIDATED_PAYMENT.equals(saleMessage.saleEvent())) {
            log.info("Sale finalizing...: {}", saleMessage);
            finalizeSaleInputPort.finalize(saleMessage.sale());
            log.info("Sale finalized!");
        }
    }
}
