package com.cce.transaction.application.ports;

import com.cce.transaction.domain.entity.TransactionNotificationEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/api/v1/notification")
public interface NotificationServiceClient {
    @PostExchange("/transaction")
    void sendNotification(@RequestBody TransactionNotificationEntity transactionNotificationEntity);
}
