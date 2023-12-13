Feature: Manage Sprint functionality
  Scenario Outline: create and start a Sprint
    Given I logged in as a team leader
    When I nevigate to "<projectName>" projects page
    And I click on create sprint
    And I enter the "<sprintName>" and click confirm
    And I create an issue in that sprint
    And I click on start sprint
    Then I should be able to see "<sprintName>" appears in the sprints group

    Examples:
    |projectName |sprintName |
    |jira-testing|Test Sprint|