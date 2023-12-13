Feature: assign issues to different users
  Scenario: Assign issue "Test" (SCRUM4-5) to user "admin"
    Given I am logged in as admin and at the issue page
    And I click on assignee button and add an assignee
    Then I can see the assignee updated