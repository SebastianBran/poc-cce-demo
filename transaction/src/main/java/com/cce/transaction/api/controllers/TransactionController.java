package com.cce.transaction.api.controllers;

import com.cce.transaction.api.dto.request.CreateTransactionRequestDto;
import com.cce.transaction.application.ports.TransactionService;
import com.cce.transaction.domain.entity.TransactionEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping()
    public List<TransactionEntity> getAll() {
        return this.transactionService.getAll();
    }

    @PostMapping()
    public TransactionEntity create(@Valid @RequestBody CreateTransactionRequestDto createTransactionRequestDto) {
        TransactionEntity transactionEntity =
                new TransactionEntity(createTransactionRequestDto.getSenderPhoneNumber(),
                        createTransactionRequestDto.getSenderEmail(),
                        createTransactionRequestDto.getReceiverPhoneNumber(),
                        createTransactionRequestDto.getAmount(),
                        createTransactionRequestDto.getCurrency(),
                        createTransactionRequestDto.getEntityId());
        return this.transactionService.create(transactionEntity);
    }
}
