Feature: Asset Ledger

  Scenario: Multiple messages processed to calculate holdings
    Given Consumed ledger Postings messages with following data:
      | accountId | instrumentId     | quantity | ledgerGroup   | transactionType       |
      | A123      | VODAFONE         | 100      | ACCOUNT_ASSET | PURCHASE_OF_SECURITY  |
      | A123      | VODAFONE         | 50       | ACCOUNT_ASSET | SALE_OF_SECURITY      |
    When the balance is calculated
    Then the balance calculated should be 50

  Scenario: Multiple messages processed to calculate holdings
    Given Consumed ledger Postings messages with following data:
      | accountId | instrumentId     | quantity | ledgerGroup   | transactionType       |
      | A123      | VODAFONE         | 100      | ACCOUNT_ASSET | PURCHASE_OF_SECURITY  |
      | A123      | VODAFONE         | 50       | ACCOUNT_ASSET | SALE_OF_SECURITY      |
      | B123      | VODAFONE         | 100      | ACCOUNT_ASSET | PURCHASE_OF_SECURITY  |
      | B123      | VODAFONE         | 70       | ACCOUNT_ASSET | SALE_OF_SECURITY      |
    When the balance is calculated
    Then the balance calculated for each account should be:
      | accountId | instrumentId     | ledgerGroup   | transactionType       | balance       |
      | A123      | VODAFONE         | ACCOUNT_ASSET | PURCHASE_OF_SECURITY  | 50            |
      | B123      | VODAFONE         | ACCOUNT_ASSET | PURCHASE_OF_SECURITY  | 30            |


