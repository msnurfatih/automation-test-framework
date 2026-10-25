@api
Feature: DummyAPI User

  Scenario: Get user by ID
    Given the DummyAPI request is configured
    When the user requests a user by ID "60d0fe4f5311236168a109f6"
    Then the user API response status code should be 200
    And the user response should contain an ID

  Scenario: Create a new user
    Given the DummyAPI request is configured
    When the user creates a new user with name "QA Test User"
    Then the user creation response status code should be 200
    And the created user response should contain an ID

  Scenario: Update an existing user
    Given the DummyAPI request is configured
    When the user updates a user by ID "60d0fe4f5311236168a109f6" with name "QA Updated User"
    Then the user update response status code should be 200
