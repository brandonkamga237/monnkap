package com.brandonkamga.monnkap.service;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override 
    public List<Transaction> getAllTransactions() throws IOException {
        return transactionRepository.getAll();
    }

    @Override 
    public Optional<Transaction> getTransactionByNum(UUID num) throws IOException {
        return transactionRepository.getByNum(num);
    }
}