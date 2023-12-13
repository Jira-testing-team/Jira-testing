Feature: specify if the current issue is blocked by or is blocking other issues
  Scenario: In project "Scrum3", use issue link to specify issue "SCRUM3-17" is blocked by "SCRUM3-18"
#manually add SCRUM3-18 in project here
    Given I am logged in as admin and at the issue page
    And I click More dorpdown and click on Link
    And I choose link type 'blocked by', issue to link and submit
    Then I can see a link that issue "SCRUM3-17" is blocked by "SCRUM3-18"