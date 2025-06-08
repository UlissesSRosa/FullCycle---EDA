package com.fullcycle.eda.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BalanceResponseDTO {
    private UUID accountId;
    private BigDecimal balance;
}