package com.brandonkamga.monnkap.repository;

import java.io.IOException;

import com.brandonkamga.monnkap.domain.Transaction;

public interface TransactionRepository {

    void save(Transaction t) throws IOException;
}