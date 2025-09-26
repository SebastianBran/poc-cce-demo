package com.cce.notification.infrastructure.adapters;

import com.cce.notification.application.ports.NotificationRepository;
import com.cce.notification.application.ports.TransactionNotificationService;
import com.cce.notification.domain.entity.TransactionNotificationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionNotificationServiceImpl implements TransactionNotificationService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionNotificationServiceImpl.class);

    private final NotificationRepository notificationRepository;

    public TransactionNotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<TransactionNotificationEntity> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public TransactionNotificationEntity send(TransactionNotificationEntity transactionNotificationEntity) {
        logger.info("{} send ${} to {}",
                transactionNotificationEntity.getSenderEmail(),
                transactionNotificationEntity.getAmount(),
                transactionNotificationEntity.getReceiverPhoneNumber());
        return notificationRepository.save(transactionNotificationEntity);
    }
}
