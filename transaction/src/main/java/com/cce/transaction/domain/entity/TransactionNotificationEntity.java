package com.cce.transaction.domain.entity;

public class TransactionNotificationEntity {
    private String senderEmail;
    private String receiverPhoneNumber;
    private Long amount;

    public TransactionNotificationEntity() {}

    public TransactionNotificationEntity(String senderEmail, String receiverPhoneNumber, Long amount) {
        this.senderEmail = senderEmail;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.amount = amount;
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
