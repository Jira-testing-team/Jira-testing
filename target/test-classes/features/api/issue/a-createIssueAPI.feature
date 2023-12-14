Feature: Create issues that belong to different epics and priorities in an existing project using API
  Scenario Outline: I can create 2 issues in the project,
    Given I have project key, priority levels, epicId and storyId of project <projectKey>
    Then I can create a issue with <issueSummary>, issueType, <reporter>, <priorityLevel> using a post request

    Examples:
      |projectKey   |issueSummary |reporter|priorityLevel|
      |"SCRUMPROJ3" |"issue1"     |"lead"  |"highest"    |
      |"SCRUMPROJ3" |"issue2"     |"lead"  |"medium"     |