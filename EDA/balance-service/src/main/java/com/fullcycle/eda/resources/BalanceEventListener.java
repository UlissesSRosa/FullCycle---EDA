package com.fullcycle.eda.resources;

import com.fullcycle.eda.dto.TransactionEventDTO;
import com.fullcycle.eda.services.BalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BalanceEventListener {

    private final BalanceService balanceService;

    @KafkaListener(topics = "wallet-transactions", groupId = "balance-group", containerFactory = "kafkaListenerContainerFactory")
    public void onTransactionEvent(TransactionEventDTO event) {
        log.info("Received transaction event: {}", event);
        balanceService.handleTransaction(event);
    }
}