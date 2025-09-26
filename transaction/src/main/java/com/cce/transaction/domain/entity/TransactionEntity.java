package com.cce.transaction.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "money_transaction")
public class TransactionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "sender_phone_number", nullable = false)
    private String senderPhoneNumber;

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

    @NotNull
    @Column(name = "currency", nullable = false)
    private Long currency;

    @NotNull
    @NotBlank
    @Column(name = "entity_id", nullable = false)
    private String entityId;

    public TransactionEntity() {}

    public TransactionEntity(String senderPhoneNumber, String senderEmail, String receiverPhoneNumber, Long amount, Long currency, String entityId) {
        this.senderPhoneNumber = senderPhoneNumber;
        this.senderEmail = senderEmail;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.amount = amount;
        this.currency = currency;
        this.entityId = entityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
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

    public Long getCurrency() {
        return currency;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
