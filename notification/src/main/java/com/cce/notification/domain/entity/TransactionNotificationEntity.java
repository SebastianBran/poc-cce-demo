package com.cce.notification.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "notification")
public class TransactionNotificationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "sender_email", nullable = false)
    private String senderEmail;

    @NotNull
    @NotBlank
    @Column(name = "receiver_phone_number", nullable = false)
    private String receiverPhoneNumber;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Long amount;

    public TransactionNotificationEntity() {}

    public TransactionNotificationEntity(String senderEmail, String receiverPhoneNumber, Long amount) {
        this.senderEmail = senderEmail;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
