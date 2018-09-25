package bdd.asset_ledger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AssetLedgerPostingsSteps {

    private List<AssetLedger> assetLedgerList;
    private int balance;
    private Map<String, AssetLedger> assetBalanceMap = new HashMap<String, AssetLedger>();

    @Given("^Consumed ledger Postings messages with following data:$")
    public void consumedLedgerPostingsMessagesWithFollowingData(List<AssetLedger> assetLedgerList) {
        this.assetLedgerList = assetLedgerList;
    }

    @When("^the balance is calculated$")
    public void theBalanceIsCalculated() {
        updateBalance();
    }


    private void updateBalance() {
        for (AssetLedger assetLedger : assetLedgerList) {
            int localBalance = 0;
            String key = assetLedger.getAccountId() + assetLedger.getInstrumentId()
                    + assetLedger.getLedgerGroup() + "PURCHASE_OF_SECURITY";
            AssetLedger assetLedger1 = assetBalanceMap.get(key);
            if (assetLedger1 != null) {
                localBalance = assetLedger1.getBalance().intValue();
            }

            if (assetLedger.getTransactionType().equalsIgnoreCase("PURCHASE_OF_SECURITY")) {
                balance += assetLedger.getQuantity().intValue();
                localBalance += assetLedger.getQuantity().intValue();
            } else if (assetLedger.getTransactionType().equalsIgnoreCase("SALE_OF_SECURITY")) {
                balance -= assetLedger.getQuantity().intValue();
                localBalance -= assetLedger.getQuantity().intValue();
            }

            assetLedger.setBalance(BigDecimal.valueOf(localBalance));
            assetBalanceMap.put(key, assetLedger);
        }
    }


    @Then("^the balance calculated should be (\\d+)$")
    public void theBalanceShouldBe(int balance) {
        assertThat(this.balance, is(balance));
    }


    @Then("^the balance calculated for each account should be:$")
    public void theBalanceCalculatedForEachAccountShouldBe(List<AssetBalance> assetBalanceList) {
        for (AssetBalance assetBalance : assetBalanceList) {
            String key = assetBalance.getAccountId() + assetBalance.getInstrumentId()
                    + assetBalance.getLedgerGroup() + "PURCHASE_OF_SECURITY";
            AssetLedger assetLedger = assetBalanceMap.get(key);
            assertThat(assetLedger.getBalance().intValue(), is(assetBalance.getBalance().intValue()));
        }
    }
}