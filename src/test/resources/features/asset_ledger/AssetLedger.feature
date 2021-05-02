Feature: Calculator Application
    
Scenario: Purchase of Asset
    Given that account Id is "A123"
    And the instrument Id is "IBM"
    And the quantity is 100
    And the balance is 0
    And the ledger group is "ACCOUNT_ASSET"
    And the transaction type is "PURCHASE_OF_SECURITY"
    When the trade is placed
    Then the balance should be 100

  Scenario: Sale of Asset
    Given that account Id is "A123"
    And the instrument Id is "IBM"
    And the quantity is 100
    And the balance is 150
    And the ledger group is "ACCOUNT_ASSET"
    And the transaction type is "SALE_OF_SECURITY"
    When the trade is placed
    Then the balance should be 50