@api
Feature: DummyAPI Tag

  Scenario: Get list of tags
    Given the DummyAPI request is configured
    When the user requests the list of tags
    Then the API response status code should be 200
    And the response should contain a list of tags
