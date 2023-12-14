Feature: add an Epic to existing project
  Scenario: Add a new epic "Frontend" into scrum project "SCRUM4"
    Given I am logged in as admin and at the project backlog page
    And I click on epic menu and epic button
    And I submit info to create a new epic and click create
    Then I can see a new epic "Frontend" in backlog page