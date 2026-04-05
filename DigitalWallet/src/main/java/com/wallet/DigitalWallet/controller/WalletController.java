package com.wallet.DigitalWallet.controller;

import com.wallet.DigitalWallet.dto.request.AddMoneyRequest;
import com.wallet.DigitalWallet.dto.request.TransferRequest;
import com.wallet.DigitalWallet.dto.response.WalletResponse;
import com.wallet.DigitalWallet.entity.Wallet;
import com.wallet.DigitalWallet.service.TransactionService;
import com.wallet.DigitalWallet.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;
    private final TransactionService transactionService;

    @PostMapping("/add-money")
    public ResponseEntity<WalletResponse> addMoney(@RequestBody AddMoneyRequest request) {

        Wallet wallet = walletService.addMoney(request.getUserId(), request.getAmount());

        WalletResponse response = new WalletResponse();
        response.setUserId(wallet.getUser().getId());
        response.setBalance(wallet.getBalance());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferRequest request) {

        String result = transactionService.transfer(
                request.getSenderId(),
                request.getReceiverId(),
                request.getAmount()
        );

        return ResponseEntity.ok(result);
    }
}
