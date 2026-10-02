package com.brandonkamga.monnkap.service;

import java.io.IOException;

import com.brandonkamga.monnkap.domain.Transaction;

public interface TransactionService {
    
    void addTransaction(Transaction t) throws IOException;

    void getAllTransactions(Transaction t) throws IOException;
}
