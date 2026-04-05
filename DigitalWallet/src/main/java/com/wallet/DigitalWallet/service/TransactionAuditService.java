package com.wallet.DigitalWallet.service;

import com.wallet.DigitalWallet.entity.Transaction;
import com.wallet.DigitalWallet.entity.Wallet;
import com.wallet.DigitalWallet.repository.TransactionRepository;
import com.wallet.DigitalWallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionAuditService {

    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveFailedTransaction(Long senderId, Long receiverId, BigDecimal amount, String reason) {

        Wallet sender = walletRepository.findByUserId(senderId).orElse(null);
        Wallet receiver = walletRepository.findByUserId(receiverId).orElse(null);

        Transaction failedTxn = new Transaction();
        failedTxn.setSender(sender);
        failedTxn.setReceiver(receiver);
        failedTxn.setAmount(amount);
        failedTxn.setStatus("FAILED");
        failedTxn.setTimestamp(LocalDateTime.now());
        // Optional:
        // failedTxn.setFailureReason(reason);

        transactionRepository.save(failedTxn);
    }
}