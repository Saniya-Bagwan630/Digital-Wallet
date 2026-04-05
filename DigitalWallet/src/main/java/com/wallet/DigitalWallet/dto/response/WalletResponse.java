package com.wallet.DigitalWallet.dto.response;

import java.math.BigDecimal;

public class WalletResponse {
    private Long userId;
    private BigDecimal balance;

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
