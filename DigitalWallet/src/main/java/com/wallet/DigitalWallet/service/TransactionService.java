package com.wallet.DigitalWallet.service;

import com.wallet.DigitalWallet.entity.Transaction;
import com.wallet.DigitalWallet.entity.Wallet;
import com.wallet.DigitalWallet.exception.InsufficientBalanceException;
import com.wallet.DigitalWallet.exception.InvalidInputException;
import com.wallet.DigitalWallet.exception.UserNotFoundException;
import com.wallet.DigitalWallet.repository.TransactionRepository;
import com.wallet.DigitalWallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionAuditService auditService;

    // ==============================
    // ENTRY POINT
    // ==============================
    public String transfer(Long senderId, Long receiverId, BigDecimal amount) {

        try {
            return performTransfer(senderId, receiverId, amount);
        } catch (RuntimeException e) {

            // Save FAILED txn in separate transaction
            auditService.saveFailedTransaction(senderId, receiverId, amount, e.getMessage());

            throw e;
        }
    }

    // ==============================
    // CORE LOGIC
    // ==============================
    @Transactional
    public String performTransfer(Long senderId, Long receiverId, BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidInputException("Invalid amount");
        }

        if (senderId.equals(receiverId)) {
            throw new InvalidInputException("Cannot transfer to same user");
        }

        Wallet sender = walletRepository.findByUserId(senderId)
                .orElseThrow(() -> new UserNotFoundException("Sender not found"));

        Wallet receiver = walletRepository.findByUserId(receiverId)
                .orElseThrow(() -> new UserNotFoundException("Receiver not found"));

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        // Deduct & Add
        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));

        // SUCCESS txn
        Transaction txn = new Transaction();
        txn.setSender(sender);
        txn.setReceiver(receiver);
        txn.setAmount(amount);
        txn.setStatus("SUCCESS");
        txn.setTimestamp(LocalDateTime.now());

        transactionRepository.save(txn);

        return "Transfer successful";
    }

    // ==============================
    // TRANSACTION HISTORY
    // ==============================
    public List<Transaction> getTransactionHistory(Long userId) {

        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("Wallet not found"));

        return transactionRepository
                .findBySenderIdOrReceiverIdOrderByTimestampDesc(
                        wallet.getId(),
                        wallet.getId()
                );
    }
}