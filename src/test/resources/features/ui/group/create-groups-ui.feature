Feature: Create a group via UI
  Scenario Outline: Successful group creation
    Given I am logged in with <username> and <password> and on the dashboard page
    When I click the config button
    And click on the user management button then provide <password> to authenticate
    Then I should be in the user browsers page
    When I click on the groups button
    Then I should be in the group browsers page
    When I enter the name of the group, <groupName>
    And click the add group button
    Then the group name <groupName> I just added should appear under group name
    Examples:
      | username | password | groupName               |
      | "jzjz"   | "jzjz"   | "jira-ui-test-basic"    |
      | "bob"    | "bob123" | "jira-ui-test-advanced" |
