Feature: create a Scrum project and apply an existing permission schema
  Scenario: create a new scrum project "SCRUM3" and apply the permission schema "Scrum Permission Schema"
    Given I am logged in as admin and at the dashboard page
    When I click on the Create Project in Projects drop down
    And I select scrum type, workflow and I submit project Name, Key
    Then A new scrum project is created and I'm redirected to project's page

    When I click on Project Setting and go to permission setting
    And I enter password for admin verification
    And I select "Scrum Permission Schema" in dropdown and click associate
    Then The project is applied with an existing permission schema