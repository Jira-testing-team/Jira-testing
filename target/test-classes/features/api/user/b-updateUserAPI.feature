@user
Feature: Deactivate user api
  Scenario Outline: Deactivate a user
    Given I sent a put request for changing the active status of a user with "<username>" to false
    When I get the information of this user with "<username>"
    Then I should see the value of active status is false

    Examples:
    |username|
    |mary456 |