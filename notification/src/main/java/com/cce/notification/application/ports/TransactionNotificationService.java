package com.cce.notification.application.ports;

import com.cce.notification.domain.entity.TransactionNotificationEntity;

import java.util.List;

public interface TransactionNotificationService {
    List<TransactionNotificationEntity> getAll();
    TransactionNotificationEntity send(TransactionNotificationEntity transactionNotificationEntity);
}
