Feature: Download velocity chart functionality
  Scenario Outline: download velocity chart of the last 6 months as an image
    Given I logged in as a team leader
    When I nevigate to "<projectName>" projects page
    And I click on reports tab
    And I switch to velocity chart report
    And I apply "<number>" months timeframe
    And I click on save as an image button
    Then I should see the image appear in the target location

    Examples:
    |projectName |number|
    |jira-testing|6     |