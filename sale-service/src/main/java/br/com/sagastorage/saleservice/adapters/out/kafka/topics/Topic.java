package br.com.sagastorage.saleservice.adapters.out.kafka.topics;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Topic {
    TP_SAGA_SALE("tp-saga-sale");

    private final String topic;
}
