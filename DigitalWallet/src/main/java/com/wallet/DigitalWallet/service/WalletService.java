package com.wallet.DigitalWallet.service;

import com.wallet.DigitalWallet.entity.Wallet;
import com.wallet.DigitalWallet.exception.InvalidInputException;
import com.wallet.DigitalWallet.exception.UserNotFoundException;
import com.wallet.DigitalWallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    public Wallet addMoney(Long userId, BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidInputException("Amount must be positive");
        }

        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("Wallet/User not found"));

        wallet.setBalance(wallet.getBalance().add(amount));

        return walletRepository.save(wallet);
    }
}