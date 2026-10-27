
@web
Feature: DemoBlaze Web UI

  Scenario: Open the DemoBlaze homepage
    Given the user opens the DemoBlaze homepage
    Then the homepage title should be displayed

  Scenario: View product categories
    Given the user opens the DemoBlaze homepage
    Then the "Phones" category should be displayed

  Scenario: View product details
    Given the user opens the DemoBlaze homepage
    When the user selects the first available product
    Then the product details should be displayed

  Scenario: Add a product to the cart
    Given the user opens the DemoBlaze homepage
    When the user selects the first available product
    And the user adds the product to the cart
    And the user opens the shopping cart
    Then the shopping cart should contain a product

  Scenario: Complete checkout end-to-end
    Given the user opens the DemoBlaze homepage
    When the user selects the first available product
    And the user adds the product to the cart
    And the user opens the shopping cart
    And the user proceeds to checkout
    And the user completes checkout with name "QA Tester", country "Indonesia", city "Jakarta", card "4111111111111111", month "10", and year "2027"
    Then the order confirmation should be displayed
