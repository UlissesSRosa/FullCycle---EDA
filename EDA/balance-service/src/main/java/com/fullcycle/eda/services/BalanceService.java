package com.fullcycle.eda.services;

import com.fullcycle.eda.dto.TransactionEventDTO;
import com.fullcycle.eda.repositories.BalanceRepository;
import com.fullcycle.eda.repositories.entities.BalanceEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;

    @Transactional
    public void handleTransaction(TransactionEventDTO event) {
        UUID accountId = event.getAccountId();
        BigDecimal amount = event.getAmount();
        String type = event.getType();

        BalanceEntity balance = balanceRepository.findById(accountId)
                .orElse(BalanceEntity.builder()
                        .accountId(accountId)
                        .amount(BigDecimal.ZERO)
                        .build());

        BigDecimal newAmount = "DEPOSIT".equalsIgnoreCase(type)
                ? balance.getAmount().add(amount)
                : balance.getAmount().subtract(amount);

        balance.setAmount(newAmount);
        balanceRepository.save(balance);
    }

    @Transactional
    public BalanceEntity getBalance(UUID accountId) {
        return balanceRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}