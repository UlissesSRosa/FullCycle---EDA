package com.fullcycle.eda.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TransactionEventDTO {
    private UUID accountId;
    private String type;
    private BigDecimal amount;
}