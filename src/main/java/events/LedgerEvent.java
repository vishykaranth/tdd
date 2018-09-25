package events;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;
import java.util.UUID;

public class LedgerEvent extends ApplicationEvent {


    // Must has this constructor, the first parameter should be event source(which object trigger this event)
    public LedgerEvent(Object source, String accountId, BigDecimal quantity, String instrumentId,
                       String ledgerGroup, String transactionType, BigDecimal balance) {
        // Must call this super class constructor first.
        super(source);
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.accountId = accountId;
        this.quantity = quantity;
        this.instrumentId = instrumentId;
        this.ledgerGroup = ledgerGroup;
        this.transactionType = transactionType;
        this.balance = balance;
    }


    private Long id;

    private String accountId;

    private BigDecimal quantity;

    private String instrumentId;

    private String ledgerGroup;

    private String transactionType;

    private BigDecimal balance;

    @Override
    public String toString() {
        return "AssetLedger{" +
                "id=" + id +
                ", accountId='" + getAccountId() + '\'' +
                ", quantity='" + getQuantity() + '\'' +
                ", instrumentId='" + getInstrumentId() + '\'' +
                ", ledgerGroup='" + getLedgerGroup() + '\'' +
                ", transactionType='" + getTransactionType() + '\'' +
                ", balance='" + getBalance() + '\'' +
                '}';
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getLedgerGroup() {
        return ledgerGroup;
    }

    public void setLedgerGroup(String ledgerGroup) {
        this.ledgerGroup = ledgerGroup;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }
}
