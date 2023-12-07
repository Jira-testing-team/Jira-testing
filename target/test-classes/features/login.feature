Feature: Login functionality
  @positive
  Scenario: Valid login
    Given I am on the login page
    When I enter the valid credentials
    And click the login button
    Then I should be directed to the dashboard page

  @negative
  Scenario: Invalid login
    Given I am on the login page
    When I enter the invalid credentials
    And click the login button
    Then I should stay in the login page