package com.cce.notification.api.controllers;

import com.cce.notification.api.dto.request.CreateTransactionNotificationRequest;
import com.cce.notification.application.ports.TransactionNotificationService;
import com.cce.notification.domain.entity.TransactionNotificationEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {
    private final TransactionNotificationService transactionNotificationService;

    public NotificationController(TransactionNotificationService transactionNotificationService) {
        this.transactionNotificationService = transactionNotificationService;
    }

    @GetMapping("/transaction")
    public List<TransactionNotificationEntity> getAll() {
        return transactionNotificationService.getAll();
    }

    @PostMapping("/transaction")
    public TransactionNotificationEntity create(@Valid @RequestBody CreateTransactionNotificationRequest createTransactionNotificationRequest) {
        TransactionNotificationEntity transactionNotificationEntity =
                new TransactionNotificationEntity(
                        createTransactionNotificationRequest.getSenderEmail(),
                        createTransactionNotificationRequest.getReceiverPhoneNumber(),
                        createTransactionNotificationRequest.getAmount());
        return transactionNotificationService.send(transactionNotificationEntity);
    }
}
