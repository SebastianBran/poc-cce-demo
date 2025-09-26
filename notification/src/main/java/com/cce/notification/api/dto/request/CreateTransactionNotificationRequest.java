package com.cce.notification.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTransactionNotificationRequest {
    @NotNull
    @NotBlank
    @Email
    private String senderEmail;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String receiverPhoneNumber;

    @NotNull
    private Long amount;

    public CreateTransactionNotificationRequest() {
    }

    public CreateTransactionNotificationRequest(String senderEmail, String receiverPhoneNumber, Long amount) {
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
