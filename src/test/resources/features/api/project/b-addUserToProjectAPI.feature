@project

Feature: Add a user to an existing project
  Scenario Outline: I can add a user to project using API
    Given I have project information of project <projectKey>
    Then I can add user <username> to project as a role <role>

    Examples:
      |projectKey   |username   |role       |
      |"SCRUMPROJ3" |"jzjz"|"developer"|