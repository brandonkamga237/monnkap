package com.brandonkamga.monnkap.unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.brandonkamga.monnkap.domain.Transaction;
import com.brandonkamga.monnkap.domain.TransactionType;
import com.brandonkamga.monnkap.repository.TransactionRepository;
import com.brandonkamga.monnkap.service.TransactionService;
import com.brandonkamga.monnkap.service.TransactionServiceImpl;

public class TransactionServiceTest {

    @Test 
    void shouldSaveTransaction() throws IOException{

        // Arrange
        TransactionRepository repository = mock(TransactionRepository.class);

        TransactionService service = new TransactionServiceImpl(repository);

        Transaction t = new Transaction("nothing", BigDecimal.ZERO,TransactionType.IN);

        // Act
        service.addTransaction(t);

        // Assert
        verify(repository).save(t);

    }
}
