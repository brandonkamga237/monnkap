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

    public UUID getNum() {
        return this.num;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription( String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }
    public void setAmount( BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }
    public void setTransactionType( TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}