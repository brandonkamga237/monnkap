import java.util.ArrayList;

public class TransactionManager {
    private ArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }
}
