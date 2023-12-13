Feature: Edit columns in scrum board
  Scenario Outline: As an admin, I can add/delete/edit columns in the scrum board
    Given I am logged in with <username> and <password>
    When I am on the dashboard page and click settings button and click issues button
    And authenticate with my <password> and click confirm button
    And click on workflow schemes button
    And click on edit button for the first project
    And click on add workflow button and click on add existing button
    And scroll until <workflowName> is present and click on it
    And click on the next button and check select all to assign workflow to all issues
    And click finish button and click publish button
    And click Associate button and wait until acknowledge button is present then click it
    And click boards and click on the first project
    And click on the sprint board view on the board page
    And click on board and select configure
    And click on columns and check to see if the steps are correct and present
    And add and delete columns as necessary to the workflow structure
    And drag and drop the columns to the correct order
    And drag and drop the statuses under unmapped statuses to their correct column
    And click back to board
    Then the order of the columns we edited should appear correctly with the issues shown below
    Examples:
      | username | password | workflowName       |
      | "jzjz"   | "jzjz"   | "workflow-test-01" |
      | "bob"    | "bob123" | "workflow-test-12" |
