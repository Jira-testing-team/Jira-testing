Feature: specify if the current issue is blocked by or is blocking other issues by linking issues
  Scenario: I can set a link relation between two issues
    Given I have the linkType and have two issues in a project
    Then I can set issue1 to block issue2