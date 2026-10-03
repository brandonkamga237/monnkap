package com.brandonkamga.monnkap.repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.brandonkamga.monnkap.domain.Transaction;
import com.brandonkamga.monnkap.domain.TransactionType;

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
        Files.writeString(
            path,
            t.toString() + System.lineSeparator(),
            StandardOpenOption.APPEND
            );
    }

    @Override
    public List<Transaction> getAll() throws IOException{
        return  Files.readAllLines(path)
                .stream()
                .map(line -> {
                    String parts[] = line.split(";");
                    return new Transaction(
                        UUID.fromString(parts[0]),
                        parts[2],
                        new BigDecimal(parts[1]),
                        TransactionType.valueOf(parts[3]));
                } ).toList();

    }

    @Override 
    public Optional<Transaction> getByNum(UUID num) throws IOException {
        return getAll().stream()
                .filter(t -> t.getNum().equals(num))
                .findFirst();
    }
}