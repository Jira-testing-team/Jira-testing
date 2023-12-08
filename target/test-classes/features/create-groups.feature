Feature: Create a group
  Scenario: Successful group creation
    Given I am logged in and on the dashboard page
    When I click the config button
    And click on the user management button
    Then I should be in the user browsers page
    When I click on the groups button
    Then I should be in the group browsers page
    When I enter the name of the group
    And click the add group button
    Then the name I just added should appear under group name
