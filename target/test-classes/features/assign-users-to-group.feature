Feature: Assign users to groups
  Scenario: Successful addition of user to group
    Given I am logged in and on the group browser page
    When I click on bulk edit group members
    Then I should be on the bulk edit group members page
    When I enter and select the name of the group
    And enter the user, and click the add selected users button
    Then the added user should be under group members