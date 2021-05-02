package bdd.asset_ledger;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssetBalanceTest {

    @Test
    public void testAssetBalance(){
        AssetBalance assetBalance = new AssetBalance();
        assetBalance.setAccountId("ABC");
        assertThat(assetBalance.getAccountId(), is("ABC"));
        System.out.println(assetBalance);
    }


//    AssetLedger{id=null, accountId='ABC', quantity='null', instrumentId='null', ledgerGroup='null', transactionType='null', balance='null'}
//    AssetBalance(id=null, accountId=ABC, quantity=null, instrumentId=null, ledgerGroup=null, transactionType=null, balance=null)
}