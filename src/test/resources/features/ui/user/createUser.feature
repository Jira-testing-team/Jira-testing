Feature: create new user functionality
  Scenario Outline: create three new users
    Given I logged in as an admin
    When I click on setting on the dashboard page
    And I click on User management
    And I enter credentials for administrator
    And I click on Create user
    And I enter "<fullName>", "<email>", "<username>", and "<password>"
    And I click on Create
    Then The newly created user with "<username>" should be displayed in the user table

    Examples:
    |fullName    |email                |username  |password|
    |Charlie Paul|charlie@atlassian.com|charlie123|test123|
    |Jacky Chen  |jacky@atlassian.com  |jacky123  |test234|
    |Jason Ma    |jason@atlassian.com  |jason123  |test345|