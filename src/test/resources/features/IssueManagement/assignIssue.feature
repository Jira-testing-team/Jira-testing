Feature: assign issues to different users
  Scenario: Assign issue "Test" (SCRUM3-17) to user "lead"
    Given I am logged in as admin and at the issue page
    And I click on assignee button and add an assignee
    Then I can see the assignee updated