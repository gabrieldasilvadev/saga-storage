package br.com.sagastorage.saleservice.adapters.out.kafka.groups;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GroupId {
    SALE("sale");

    private final String groupId;
}
