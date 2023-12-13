Feature: Create an Epic in an existing project using API
  Scenario Outline: I can create an epic in project
    Given I have project key and epicId of project <projectKey>
    Then I can create an epic with <epicName>, <summary>, issueType, <reporter> using post request

    Examples:
    |projectKey   |epicName   |summary  |reporter|
    |"SCRUMPROJ3" |"Backend"  |"test"   |"lead"  |