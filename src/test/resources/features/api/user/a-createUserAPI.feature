@user
Feature: Create user API testing
  Scenario Outline: Create a new user
    Given I send the request for creating user with user information as "<name>", "<password>", "<emailAddress>", "<displayName>"
    Then I should get the status code of 201 indicating I sucessfully created the user

    Examples:
    |name   |password|emailAddress|displayName|
    |mary456|test123 |mary@123.com|Mary Aung  |
    |jessie1|test123 |jessie@3.com|Jessie Li  |
    |bob123 |test123 |bob22@js.com|Bob Zhang  |