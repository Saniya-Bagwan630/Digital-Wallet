package com.wallet.DigitalWallet.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_wallet_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "receiver_wallet_id")
    private Wallet receiver;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String status; // SUCCESS / FAILED

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setReceiver(Wallet receiver) {
        this.receiver = receiver;
    }

    public void setSender(Wallet sender) {
        this.sender = sender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public Wallet getReceiver() {
        return receiver;
    }

    public Wallet getSender() {
        return sender;
    }
}
