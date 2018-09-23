package bdd.asset_ledger;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AssetLedgerSteps {
    private String accountId;
    private String instrumentId;
    private BigDecimal quantity;
    private BigDecimal balance;
    private String ledgerGroup;
    private String transactionType;
    private Map<String, AssetLedger> assetCache = new HashMap<String, AssetLedger>();

    @Given("^that account Id is \"(.*?)\"$")
    public void thatAccountIdIs(String accountId) {
        this.accountId = accountId;
    }

    @And("^the instrument Id is \"(.*?)\"$")
    public void theInstrumentIdIs(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    @And("^the quantity is (\\d+)$")
    public void theQuantityIs(int quantity) {
        this.quantity = BigDecimal.valueOf(quantity);
    }

    @And("^the balance is (\\d+)$")
    public void theBalanceIs(int balance) {
        this.balance = BigDecimal.valueOf(balance);
    }

    @And("^the ledger group is \"(.*?)\"$")
    public void theLedgerGroupIs(String ledgerGroup) {
        this.ledgerGroup = ledgerGroup;
    }

    @And("^the transaction type is \"(.*?)\"$")
    public void theTransactionTypeIs(String transactionType) {
        this.transactionType = transactionType;
    }

    @When("^the trade is placed$")
    public void theTradeIsPlaced(){
        updateBalance();
    }

    @Then("^the balance should be (\\d+)$")
    public void theBalanceShouldBe(int balance)  {
        assertThat(this.balance.intValue(), is(balance));
    }

    private void updateBalance() {
        String key = accountId + instrumentId + ledgerGroup;



        AssetLedger assetLedgerCache = assetCache.get(key);
        int balance = 0 + this.balance.intValue();
        if(assetLedgerCache != null) {
            balance = assetLedgerCache.getBalance().intValue();
        }

        if(transactionType.equalsIgnoreCase("PURCHASE_OF_SECURITY")){
            balance += quantity.intValue();
        }else if(transactionType.equalsIgnoreCase("SALE_OF_SECURITY")){
            balance -= quantity.intValue();
        }


        AssetLedger assetLedgerUpdated = buildAssetLedger(accountId, instrumentId, quantity,
                BigDecimal.valueOf(balance),
                ledgerGroup, transactionType);

        assetCache.put(key, assetLedgerUpdated);

        this.balance = assetCache.get(key).getBalance();

    }

    private AssetLedger buildAssetLedger(String accountId, String instrumentId, BigDecimal quantity, BigDecimal balance,
                                         String ledgerGroup, String transactionType) {
        AssetLedger assetLedger = new AssetLedger();

        assetLedger.setAccountId(accountId);
        assetLedger.setInstrumentId(instrumentId);
        assetLedger.setQuantity(quantity);
        assetLedger.setBalance(balance);
        assetLedger.setLedgerGroup(ledgerGroup);
        assetLedger.setTransactionType(transactionType);
        return assetLedger;
    }


}
