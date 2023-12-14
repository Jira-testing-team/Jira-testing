@project

Feature: Create a project with a existing permission schema using APIs
  Scenario Outline: I can create a project, afterward I can fetch it using projectId
    When I create a project with <key>, <name>, <type>, <template>, <lead>, <permissionScheme>
    And I get the created project with project key <key>
    Then The project info should match with <key>, <name>

    Examples:
      | key         |name       |type       |template                                       |lead   |permissionScheme|
      |"SCRUMPROJ3" |"Project3" |"software" |"com.pyxis.greenhopper.jira:gh-scrum-template" |"admin" |10000           |
