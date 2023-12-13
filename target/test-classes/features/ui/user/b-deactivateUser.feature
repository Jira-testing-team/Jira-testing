Feature: deactivate users functionality
  Scenario Outline: dectivate an existing user
    Given I logged in as an admin
    When I click on setting on the dashboard page
    And I click on User management
    And I enter credentials for administrator
    And I click on edit of the user with "<username>"
    And I uncheck the active option and click update
    Then I should be able to see user with "<username>" appears when I apply the filter of inactive users
    And This user cannot login with "<username>" and "<password>" anymore

    Examples:
    |username  |password|
    |charlie123|test123 |
