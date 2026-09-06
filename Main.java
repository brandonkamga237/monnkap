import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("Take out the trash", new BigDecimal("10.00"), TransactionType.OUT));
        transactions.add(new Transaction("Get groceries", new BigDecimal("50.00"), TransactionType.OUT));

        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println("- " + transaction.getDescription() + ": " + transaction.getAmount());
        }
    }
}