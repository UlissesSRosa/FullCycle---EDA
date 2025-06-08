package com.fullcycle.eda.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Getter
@Setter
@Builder
public class TransactionEventDTO {
    private UUID accountId;
    private String type;
    private BigDecimal amount;
}