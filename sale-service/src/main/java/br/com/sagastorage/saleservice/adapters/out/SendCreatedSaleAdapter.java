package br.com.sagastorage.saleservice.adapters.out;

import br.com.sagastorage.saleservice.adapters.out.kafka.messages.SaleMessage;
import br.com.sagastorage.saleservice.adapters.out.kafka.topics.Topic;
import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.core.domain.enums.SaleEvent;
import br.com.sagastorage.saleservice.application.ports.out.SendCreatedSaleOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send(Topic.TP_SAGA_SALE.getTopic(), saleMessage);
    }
}
