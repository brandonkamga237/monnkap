import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public class FileTransactionRepository implements TransactionRepository{

    private final Path file = Path.of("db.txt");

    public FileTransactionRepository () {
        if(!Files.exists(file)) {
            try {
                Files.createFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(Transaction transaction) {
        try {
            Files.writeString(file, transaction.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Transaction findById(UUID uuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
