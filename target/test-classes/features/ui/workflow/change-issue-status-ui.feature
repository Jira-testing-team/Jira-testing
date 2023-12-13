Feature: Change the status of an issue
  Scenario Outline: As a developer user, I can change issues from "To Do" > "In Progress" > "Resolved"
    Given I am logged in as a developer with <username> and <password>
    When I am on the dashboard page and click the boards button and click on view all boards
    And I select the project I am in and click on the jira issue by its <issueNumber> on the sprint board view
    And change the issue status from "To Do" to "In Progress" then to Resolved
    Then the status of the issue should be "Resolved"
    Examples:
      | username | password | issueNumber |
      | "jzjz"   | "jzjz"   | "16"        |

  Scenario Outline: As a QA user, I can change issues from "Resolved" to "Closed"
    Given I am logged in as a QA user with <username> and <password>
    When I am on the dashboard page and click the boards button and select view all boards
    And I choose the project I am in and click on the jira issue by its <issueNumber> on the sprint board view
    And change the issue status from "Resolved" to Canceled
    Then the status should be "Closed"
    Examples:
      | username | password | issueNumber |
      | "bob"    | "bob123" | "16"        |