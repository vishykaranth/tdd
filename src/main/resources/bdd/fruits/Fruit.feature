# new feature
# Tags: optional
    
Feature: A description
    
Scenario: A scenario
    Given the price of a "banana" is 40c
    And the price of a "apple" is 50c
    When I checkout 2 "banana"
    And I checkout 1 "apple"
    Then I should be charged 130c