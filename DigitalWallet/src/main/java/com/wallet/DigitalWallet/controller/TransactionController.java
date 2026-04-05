package com.wallet.DigitalWallet.controller;

import com.wallet.DigitalWallet.dto.response.TransactionResponse;
import com.wallet.DigitalWallet.entity.Transaction;
import com.wallet.DigitalWallet.service.TransactionService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@Validated
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<TransactionResponse>> getTransactions(@PathVariable @Positive(message = "UserId must be positive") Long userId) {

        List<Transaction> transactions = transactionService.getTransactionHistory(userId);

        List<TransactionResponse> response = transactions.stream().map(txn -> {
            TransactionResponse dto = new TransactionResponse();
            dto.setId(txn.getId());
            dto.setSenderId(txn.getSender() != null ? txn.getSender().getId() : null);
            dto.setReceiverId(txn.getReceiver() != null ? txn.getReceiver().getId() : null);
            dto.setAmount(txn.getAmount());
            dto.setStatus(txn.getStatus());
            dto.setTimestamp(txn.getTimestamp());
            return dto;
        }).toList();

        return ResponseEntity.ok(response);
    }
}
