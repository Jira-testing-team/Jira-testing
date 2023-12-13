Feature: Filter users by their group via UI
  Scenario Outline: Filter shows correct user in group
    Given I am logged on with <username> and <password> and on the users browsers page
    When I enter and select the group <groupName> I want to filter
    And click on the filter button
    Then I should see all users with the group <groupName> filter
    Examples:
      | username | password | groupName               |
      | "jzjz"   | "jzjz"   | "jira-ui-test-advanced" |
      | "bob"    | "bob123" | "jira-ui-test-basic"    |
