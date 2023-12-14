Feature:  create issues that belong to different epics and priorities in the backlog
  Scenario Outline: create an issue in project "SCRUM4" that has priority and epicLink
    Given I am logged in as admin and at the project backlog page
    And I click on the create button at header menu
    And I set type to "story" and submit <issueTitle>, <priority>, <epicName> to create a new issue with detail settings
    Then I can see a new issue <issueTitle>

    Examples:
    |issueTitle |priority |epicName  |
    |"Test1"    |"Medium" |"Frontend"|
    |"Test3"    |"Highest"|""        |