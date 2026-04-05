package com.wallet.DigitalWallet.repository;

import com.wallet.DigitalWallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email (useful later)
    Optional<User> findByEmail(String email);
}