package com.cce.notification.application.ports;

import com.cce.notification.domain.entity.TransactionNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<TransactionNotificationEntity, Long> {}
