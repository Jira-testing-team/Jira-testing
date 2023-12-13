Feature: Assign users to groups via UI
  Scenario Outline: Successful addition of user to group
    Given I am logged in with <username> and <password> and on the group browser page
    When I click on bulk edit group members
    Then I should be on the bulk edit group members page
    When I enter and select the name of the group, <groupName>
    And enter the user <user>, and click the add selected users button
    Then the added user <user> should be under group members
    Examples:
      | username | password | user      | groupName               |
      | "jzjz"   | "jzjz"   | "bob"     | "jira-ui-test-basic"    |
      | "bob"    | "bob123" | "jzjz"    | "jira-ui-test-advanced" |