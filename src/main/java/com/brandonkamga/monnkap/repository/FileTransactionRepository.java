package com.brandonkamga.monnkap.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.brandonkamga.monnkap.domain.Transaction;

public class FileTransactionRepository implements TransactionRepository {

    private final Path path;

    public FileTransactionRepository(Path path) throws IOException {
        this.path = path;

        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    @Override
    public void save(Transaction t) throws IOException {
        Files.writeString(path, t.toString());
    }
}