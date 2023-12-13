Feature: add a user to existing project
  Scenario: Invite a new user "lead" into scrum project "SCRUM3"
    Given I am logged in as admin and at the project summary page
    And I click on project config and go to project users and roles page
    And I add a user "lead" to the role "Team lead"
    Then I can see the user "lead" in this project