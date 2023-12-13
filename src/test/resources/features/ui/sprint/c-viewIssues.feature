Feature: View issues functionality
  Scenario Outline: view all issues of a Sprint
    Given I logged in as a team leader
    When I nevigate to "<projectName>" projects page
    And I click on active sprints
    Then I should all issues of that sprint displayed

    Examples:
    |projectName |
    |jira-testing|