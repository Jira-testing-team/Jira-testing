Feature: view all the issues assigned to user
  Scenario: use filter "only my issues" to view the issue "SCRUM4-5" assigned to user "admin"
  Given I am logged in as admin and at the project backlog page
    And I click on filter "Only my issues"
    Then I can view all the issues assigned to me