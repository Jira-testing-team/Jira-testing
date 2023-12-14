@group
Feature: Filter users by group via API as admin user
  Scenario Outline: As an admin user, I can filter users by their group name by fetching it
    When I am logged in as an admin with <username> and <password> and fetch users by the group <groupName>
    Then I should receive a 200 status code
    Examples:
      | username | password | groupName         |
      | "jzjz"   | "jzjz"   | "paid-jira-user"  |
      | "admin"  | "admin"  | "basic-jira-user" |