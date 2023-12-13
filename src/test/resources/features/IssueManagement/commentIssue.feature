Feature: add, edit and reply to the comments of an issue
  Scenario: On issue "SCRUM3-17", I add a comment and edit it
    Given I am logged in as admin and at the issue page
    And I click on "add a comment" and add a comment
    Then I can see a new comment
    And I click on "Edit" button and edit the comment
    Then I can see a edited comment