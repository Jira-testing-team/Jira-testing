Feature: Assigning role functionality
  Scenario Outline: Assign a role to a user
    Given I logged in as an admin
    When I click on setting on the dashboard page
    And I click on User management
    And I enter credentials for administrator
    And I click on three dots of user with "<username>" and click edit user groups
    And I assign him to "<groupName>" group
    Then I should be able to see user with "<username>" appears when I apply the filter of "<groupName>" group

    Examples:
    |username |groupName|
    |jacky123 |QA       |