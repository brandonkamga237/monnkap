package com.brandonkamga.monnkap;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;

import com.brandonkamga.monnkap.domain.Transaction;
import com.brandonkamga.monnkap.domain.TransactionType;
import com.brandonkamga.monnkap.repository.FileTransactionRepository;
import com.brandonkamga.monnkap.repository.TransactionRepository;
import com.brandonkamga.monnkap.service.TransactionService;
import com.brandonkamga.monnkap.service.TransactionServiceImpl;

public class App {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("transactions.txt");

        TransactionRepository repository =
                new FileTransactionRepository(path);

        TransactionService service =
                new TransactionServiceImpl(repository);

        Transaction transaction = new Transaction("nothing", BigDecimal.ZERO,TransactionType.IN);

        service.addTransaction(transaction);
    }
}