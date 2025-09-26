package com.cce.transaction.application.ports;

import com.cce.transaction.domain.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {
    List<TransactionEntity> getAll();
    TransactionEntity create(TransactionEntity transactionEntity);
}
