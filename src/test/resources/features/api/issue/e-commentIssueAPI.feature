Feature: Add and Edit comment of an issue
  Scenario: As a user, I can add a comment to an issue, afterward I can edit it
    Given I have a issue that can be viewed by the user "developer"
    Then I can comment on that issue
    Then I can edit that comment