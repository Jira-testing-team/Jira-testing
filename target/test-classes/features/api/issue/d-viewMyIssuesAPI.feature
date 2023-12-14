Feature: view all current issues of a user
  Scenario: I can view all issues assign to me "developer"
    When I search for all the issues assigned to me
    Then I receive all the issues assigned to me