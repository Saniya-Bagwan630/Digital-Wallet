package com.wallet.DigitalWallet.service;

import com.wallet.DigitalWallet.entity.User;
import com.wallet.DigitalWallet.entity.Wallet;
import com.wallet.DigitalWallet.exception.InvalidInputException;
import com.wallet.DigitalWallet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(String name, String email) {

        if (name == null || email == null) {
            throw new InvalidInputException("Name and email are required");
        }

        if (userRepository.findByEmail(email).isPresent()) {
            throw new InvalidInputException("User already exists");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        Wallet wallet = new Wallet();
        wallet.setBalance(BigDecimal.ZERO);
        wallet.setUser(user);

        user.setWallet(wallet);

        return userRepository.save(user);
    }
}