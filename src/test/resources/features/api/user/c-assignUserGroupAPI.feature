@UserAPI
Feature: Assign user group api
  Scenario Outline: Assign a user to a group
    Given I send a post request to http://localhost:8080/rest/api/2/group/user to assign "<username>" to "<groupName>"
    Then I should get a status code of 201

    Examples:
    |username|groupName|
    |jessie1 |QA       |