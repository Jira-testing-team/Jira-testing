Feature: Complete active sprint functionality
  Scenario Outline: Complete an actice sprint
    Given I logged in as a team leader
    When I nevigate to "<projectName>" projects page
    And I click on three dots of the current active sprint
    And I click on complete sprint and click on complete
    Then I should see there are no active sprints displayed in active sprints tab

    Examples:
    |projectName |
    |jira-testing|