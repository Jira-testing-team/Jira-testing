Feature: Moving issues functionality
  Scenario Outline: Moving an issue from backlog to a sprint
    Given I logged in as a team leader
    When I nevigate to "<projectName>" projects page
    And I drag the first issue from backlog to a sprint
    Then I should see the name of that sprint appears in the sprint field of the issue

    Examples:
    |projectName |
    |jira-testing|