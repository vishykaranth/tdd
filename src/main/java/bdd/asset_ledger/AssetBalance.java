package bdd.asset_ledger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class AssetBalance {
   private Long id;

   private String accountId;

   private BigDecimal quantity;

   private String instrumentId;

   private String ledgerGroup;

   private String transactionType;

   private BigDecimal balance;

}
