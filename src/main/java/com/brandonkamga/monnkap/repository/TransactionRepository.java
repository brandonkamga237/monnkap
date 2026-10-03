package com.brandonkamga.monnkap.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.brandonkamga.monnkap.domain.Transaction;

public interface TransactionRepository {

    void save(Transaction t) throws IOException;
    List<Transaction> getAll() throws IOException;
    Optional<Transaction> getByNum(UUID num) throws IOException;
    
}