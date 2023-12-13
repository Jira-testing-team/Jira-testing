Feature: assign the current issue to a user
  Scenario: I can set a issue to a user
    Given I have a issue and in the same project with the user "developer"
    Then I can assign issue to the user "developer"