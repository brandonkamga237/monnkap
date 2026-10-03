package com.brandonkamga.monnkap.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.brandonkamga.monnkap.domain.Transaction;

public interface TransactionService {
    
    void addTransaction(Transaction t) throws IOException;

    List<Transaction> getAllTransactions() throws IOException;

    Optional <Transaction> getTransactionByNum(UUID num) throws IOException;
}
