import java.util.List;
import java.util.UUID;

public interface  TransactionRepository {

    // private final Path file = Path.of("db.txt");

    // public TransactionRepository () {
    //     if(!Files.exists(file)) {
    //         try {
    //             Files.createFile(file);
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

    void save (Transaction transaction);
    List<Transaction> findAll();
    Transaction findById(UUID uuid);

}