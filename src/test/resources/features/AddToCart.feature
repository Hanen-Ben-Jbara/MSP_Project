@E2E
Feature: Add To Cart Process
  As a customer
  I want to be able to add items to my cart 

Scenario: Add item to cart
    Given I am on the shopping website homepage
    And I have an empty shopping cart
    When I search for "parfum"
    And I select a "parfum" product from the search results
    And I click on the "Add to Cart" button
    Then the item "parfum" should be added to my shopping cart
    And the cart total should be updated accordingly

