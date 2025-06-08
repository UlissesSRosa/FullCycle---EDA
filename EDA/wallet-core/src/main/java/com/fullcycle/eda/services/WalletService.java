package com.fullcycle.eda.services;


import com.fullcycle.eda.dto.TransactionEventDTO;
import com.fullcycle.eda.dto.TransactionRequestDTO;
import com.fullcycle.eda.repositories.TransactionEventRepository;
import com.fullcycle.eda.repositories.entities.TransactionEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final TransactionEventRepository TransactionEventRepository;
    private static final String TOPIC = "wallet-transactions";
    private final KafkaTemplate<String, TransactionEventDTO> kafkaTemplate;

    @Transactional
    public void processTransaction(TransactionRequestDTO request) {
        validate(request);
        TransactionEvent entity = buildTransactionEventEntity(request);
        TransactionEventRepository.save(entity);
        TransactionEventDTO event = toEvent(request);
        kafkaTemplate.send(TOPIC, event);
    }

    private static TransactionEvent buildTransactionEventEntity(TransactionRequestDTO request) {
        return TransactionEvent.builder()
                .accountId(request.getAccountId())
                .type(request.getType())
                .amount(request.getAmount())
                .eventTime(Instant.now())
                .build();
    }

    private void validate(TransactionRequestDTO requestDTO) {
        if (requestDTO.getAmount() == null || requestDTO.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor precisa ser maior ou igual a 0");
        }
        String requestType = requestDTO.getType().trim().toUpperCase();
        if (!requestType.equals("DEPOSIT") && !requestType.equals("WITHDRAW")) {
            throw new IllegalArgumentException("Operação precisa ser de Depósito ou de Retirada");
        }
    }

    private TransactionEventDTO toEvent(TransactionRequestDTO transactionRequestDTO) {
        TransactionEventDTO transactionEventDTO = TransactionEventDTO.builder()
                                                    .accountId(transactionRequestDTO.getAccountId())
                                                    .type(transactionRequestDTO.getType().trim().toUpperCase())
                                                    .amount(transactionRequestDTO.getAmount())
                                                    .build();
        return transactionEventDTO;
    }
}