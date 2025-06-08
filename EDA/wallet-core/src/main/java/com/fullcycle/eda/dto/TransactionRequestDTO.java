package com.fullcycle.eda.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
public class TransactionRequestDTO {
    private UUID accountId;
    private String type;
    private BigDecimal amount;
}