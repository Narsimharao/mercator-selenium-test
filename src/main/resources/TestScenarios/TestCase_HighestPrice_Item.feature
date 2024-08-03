@regression
Feature: Selecting Highest Price Item from the Products List


  Scenario: select highest price item and add into the cart
    Given I am navigated to sauce demo home page
    When I login to the application
    Then I should see login is successful
    And I should see all products are displayed on Products page
    When I add the highest price product item to the card
    Then I should see item increased in the cart
    And I should see Remove button for the the highest price product item
    When I click on the cart
    Then I should see added item is displayed in the cart