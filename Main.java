import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        TransactionManager transactionManager = new TransactionManager();

        transactionManager.addTransaction(new Transaction("Take out the trash", new BigDecimal("10.00"), TransactionType.OUT));
        transactionManager.addTransaction(new Transaction("Get groceries", new BigDecimal("50.00"), TransactionType.OUT));

        System.out.println("Transactions:");
        for (Transaction transaction : transactionManager.getTransactions()) {
            System.out.println("- " + transaction.getDescription() + ": " + transaction.getAmount());
        }
    }
}