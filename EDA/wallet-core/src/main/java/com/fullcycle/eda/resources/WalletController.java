package com.fullcycle.eda.resources;

import com.fullcycle.eda.dto.TransactionRequestDTO;
import com.fullcycle.eda.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    public ResponseEntity<String> createTransaction(@RequestBody TransactionRequestDTO requestDTO) {
        try {
            walletService.processTransaction(requestDTO);
            return ResponseEntity.ok("Transaction event published");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}



