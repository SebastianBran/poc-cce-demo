package com.cce.transaction.infrastructure.adapters;

import com.cce.transaction.api.dto.response.ExistUserInEntityResponseDto;
import com.cce.transaction.application.ports.*;
import com.cce.transaction.domain.entity.TransactionEntity;
import com.cce.transaction.domain.entity.TransactionNotificationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionRepository transactionRepository;
    private final DirectoryServiceClient directoryServiceClient;
    private final NotificationServiceClient notificationServiceClient;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            DirectoryServiceClient directoryServiceClient,
            NotificationServiceClient notificationServiceClient) {
        this.transactionRepository = transactionRepository;
        this.directoryServiceClient = directoryServiceClient;
        this.notificationServiceClient = notificationServiceClient;
    }

    @Override
    public List<TransactionEntity> getAll() {
        logger.info("Get All Transactions registries");
        return transactionRepository.findAll();
    }

    @Override
    public TransactionEntity create(TransactionEntity transactionEntity) {
        ExistUserInEntityResponseDto exist = directoryServiceClient
                .userExistInEntity(
                        transactionEntity.getReceiverPhoneNumber(),
                        transactionEntity.getEntityId()
                );

        if (exist.getExist()) {
            logger.info(
                    "Create Transaction registry: Sender {} -> Receiver {}, To Entity -> {}",
                    transactionEntity.getSenderPhoneNumber(),
                    transactionEntity.getReceiverPhoneNumber(),
                    transactionEntity.getEntityId());

            TransactionNotificationEntity transactionNotificationEntity =
                    new TransactionNotificationEntity(
                            transactionEntity.getSenderEmail(),
                            transactionEntity.getReceiverPhoneNumber(),
                            transactionEntity.getAmount()
                    );

            notificationServiceClient.sendNotification(transactionNotificationEntity);

            return transactionRepository.save(transactionEntity);
        }

        String message = String.format(
                "Receiver user with phone %s not found in entity %s",
                transactionEntity.getReceiverPhoneNumber(),
                transactionEntity.getEntityId()
        );

        logger.info(message);

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
