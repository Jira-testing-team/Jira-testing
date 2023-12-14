@api
Feature: Create a group via API as admin user
  Scenario Outline: As an admin user, I can create a group and confirm it later by fetching a list of groups
    When I am logged in as an admin with <username> and <password> and create a group with the name <addedGroup>
    And fetch a list of groups using the same credentials <username> and <password>
    Then my group <addedGroup> should be in the list of groups
    Examples:
      | username | password | addedGroup        |
      | "jzjz"   | "jzjz"   | "basic-jira-user" |
      | "bob"    | "bob123" | "paid-jira-user"  |