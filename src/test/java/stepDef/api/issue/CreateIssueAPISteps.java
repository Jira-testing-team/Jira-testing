package stepDef.api.issue;

import api.IssueAPI;
import api.ProjectAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class CreateIssueAPISteps {
    private ProjectAPI projectAPI;
    private IssueAPI issueAPI;

    private String currentProjectStoryId;
    private String currentProjectEpicKey = "SCRUMPROJ3-1";
    private String currentProjectKey;
    private int priorityId;


    public CreateIssueAPISteps(){
        projectAPI = new ProjectAPI();
        issueAPI = new IssueAPI();
    }

    @Given("I have project key, priority levels, epicId and storyId of project {string}")
    public void getProjectInfo(String projectKey){
        Response response = projectAPI.getProject(projectKey);
        currentProjectStoryId = response.jsonPath().getString("issueTypes[2].id");
        currentProjectKey = response.jsonPath().getString("key");
        response.then().log().all().statusCode(200);
        assertEquals(response.getStatusCode(), 200);
    }

    @Then("I can create a issue with {string}, issueType, {string}, {string} using a post request")
    public void createIssue(String issueSummary, String reporterName, String priorityLevel){
        switch (priorityLevel){
            case "highest":
                priorityId = 1;
                break;
            case "medium":
                priorityId = 3;
                break;
        }
        String issueJSONObject = "{\n" +
                "    \"fields\":{\n" +
                "        \"project\": {\n" +
                "            \"key\": \""+currentProjectKey+"\"\n" +
                "            },\n" +
                "        \"customfield_10110\":\""+currentProjectEpicKey+"\",\n" +
                "        \"summary\": \""+issueSummary+"\",\n" +
                "        \"reporter\": {\n" +
                "            \"name\":\""+reporterName+"\"\n" +
                "        } ,\n" +
                "        \"priority\": {\n" +
                "            \"id\":\""+priorityId+"\"\n" +
                "        } ,\n" +
                "        \"issuetype\": {\n" +
                "            \"id\": "+currentProjectStoryId+"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Response response = issueAPI.postCreateIssue(issueJSONObject);
        response.then().log().all().statusCode(201);
        assertEquals(response.getStatusCode(), 201);

    }

}
