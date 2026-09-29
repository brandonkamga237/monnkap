package com.brandonkamga.monnkap.service;

import java.io.IOException;

import com.brandonkamga.monnkap.domain.Transaction;
import com.brandonkamga.monnkap.repository.TransactionRepository;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void addTransaction(Transaction t) throws IOException {
        transactionRepository.save(t);
    }
}