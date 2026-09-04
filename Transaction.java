import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {

    private UUID num;
    private String description;
    private BigDecimal amount;
    private TransactionType transactionType;

    public Transaction(String description, BigDecimal amount, TransactionType transactionType) {
        this.num = UUID.randomUUID();
        this.description = description;
        this.amount = amount;
        this.transactionType = transactionType;
    }
}
