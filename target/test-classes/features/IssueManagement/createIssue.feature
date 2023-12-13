Feature:  create issues that belong to different epics and priorities in the backlog
  Scenario: create an issue "Test" in project "Scrum3" that has priority "highest" and epicLink "Frontend"
    Given I am logged in as admin and at the project backlog page
    And I click on create issue in backlog and open it in a dialog
    And I submit info to create a new issue with detail settings
    Then I can see a new issue "Test"