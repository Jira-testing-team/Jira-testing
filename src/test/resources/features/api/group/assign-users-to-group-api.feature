Feature: Assign a user to a group via API as admin user
  Scenario Outline: As an admin user, I can assign a user to different groups and confirm by fetching group members
    When I am logged in as an admin with <username> and <password> and add a user <addedUser> to the <groupName> group
    And fetch a list of users from <groupName> using the same credentials <username> and <password>
    Then the user <addedUser> I added should be in the list of users
    Examples:
      | username | password | addedUser | groupName         |
      | "jzjz"   | "jzjz"   | "bob"     | "basic-jira-user" |
      | "bob"    | "bob123" | "jzjz"    | "paid-jira-user"  |