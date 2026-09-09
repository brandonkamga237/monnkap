import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

public class TransactionManager {
    private ArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public Transaction getTransactionByNum(UUID num) {
        return transactions.stream()
                            .filter( t -> t.getNum().equals(num) )
                            .findFirst()
                            .orElse(null);
    }

    public ArrayList<Transaction> getTransactionTypeIn() {
        return transactions.stream()
                            .filter(t -> t.getTransactionType() == TransactionType.IN)
                            .collect(
                                Collectors.toCollection(ArrayList::new)
                            );
    }

    public ArrayList<Transaction> getTransactionTypeOut() {
        return transactions.stream()
                            .filter(t -> t.getTransactionType() == TransactionType.OUT)
                            .collect(
                                Collectors.toCollection(ArrayList::new)
                            );
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void updateDescriptionTransactionByNum(UUID num, String description) {
        Transaction transaction = getTransactionByNum(num);

        if(transaction != null) {
            transaction.setDescription(description);
        }

    }

    public void updateTypeTransactionByNum(UUID num) {
        Transaction transaction = getTransactionByNum(num);

        if (transaction != null) {
            transaction.setTransactionType( 
                transaction.getTransactionType() == TransactionType.OUT 
                ? TransactionType.IN 
                : TransactionType.OUT);
        }
        
    }

    public void deleteTransactionByNum(UUID num) {
        this.transactions.removeIf(transaction -> transaction.getNum().equals(num));
    }

    public void deleteAllTransaction() {
        this.transactions.clear();
    }

}
