Feature: Create jira workflow
  Scenario Outline: As an admin, I can create a workflow as follows, To Do > In Progress > Resolved > Closed
    Given I logged in as an admin with <username> and <password>
    When I am on the dashboard page and click on the settings then issues button
    And authenticate with my <password> and click confirm
    And click on the workflows button and click on add workflow
    And enter a name <workflowName> for my workflow and click add
    And click on the text view button for workflow
    And click on edit for my first step Open
    And change the input and select the dropdown value from Open to "To Do"
    And click Update and enter and select value "In Progress" for input and dropdown and click add
    And enter and select resolved value "Resolved" for input and dropdown and click add
    And enter and select closed value "Closed" for input and dropdown and click add
    And click add transition for To Do
    And enter transition "Work begin" in input and select the destination "In Progress" in dropdown and click add
    And click add transition for In Progress
    And enter transition "Issue fixed" in input, and select the destination "Resolved" in dropdown and click add
    And click add transition for Resolved
    And enter transition "Closed out" in input and select the destination "Closed" in dropdown, and click add
    Then my workflow structure should match the sequential order of the step names
    Examples:
      | username | password | workflowName       |
      | "jzjz"   | "jzjz"   | "workflow-5" |
      | "bob"    | "bob123" | "workflow-6" |