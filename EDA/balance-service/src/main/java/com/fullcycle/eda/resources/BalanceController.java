package com.fullcycle.eda.resources;

import com.fullcycle.eda.dto.BalanceResponseDTO;
import com.fullcycle.eda.repositories.entities.BalanceEntity;
import com.fullcycle.eda.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/balances")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping("/{accountId}")
    public ResponseEntity<BalanceResponseDTO> getBalance(@PathVariable UUID accountId) {
        try {
            BalanceEntity bal = balanceService.getBalance(accountId);
            BalanceResponseDTO dto = new BalanceResponseDTO();
            dto.setAccountId(bal.getAccountId());
            dto.setBalance(bal.getAmount());
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
