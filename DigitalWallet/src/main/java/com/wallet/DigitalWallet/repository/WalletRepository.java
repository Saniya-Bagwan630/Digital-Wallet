package com.wallet.DigitalWallet.repository;

import com.wallet.DigitalWallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    // Custom method: find wallet using userId
    Optional<Wallet> findByUserId(Long userId);
}