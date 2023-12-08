Feature: Filter users by their group
  Scenario: Filter shows correct user in group
    Given I am logged on and on the users browsers page
    When I enter and select the group I want to filter
    And click on the filter button
    Then I should see all users with the group filter