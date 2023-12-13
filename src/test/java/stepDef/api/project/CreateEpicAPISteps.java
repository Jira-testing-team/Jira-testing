package stepDef.api.project;

import api.IssueAPI;
import api.ProjectAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class CreateEpicAPISteps {
    private ProjectAPI projectAPI;
    private IssueAPI issueAPI;
    private String currentProjectEpicId;
    private String currentProjectKey;

    public CreateEpicAPISteps(){
        projectAPI = new ProjectAPI();
        issueAPI = new IssueAPI();
    }


    @Given("I have project key and epicId of project {string}")
    public void getProjectInfo(String projectKey){
        Response response = projectAPI.getProject(projectKey);
        currentProjectEpicId = response.jsonPath().getString("issueTypes[4].id");
        currentProjectKey = response.jsonPath().getString("key");
        response.then().log().all().statusCode(200);
        assertEquals(response.getStatusCode(), 200);
    }

    @Then("I can create an epic with {string}, {string}, issueType, {string} using post request")
    public void createEpic(String epicName, String summary, String reporterName){
        String epicObject = "{" +
                "    \"fields\":{" +
                "        \"project\": {" +
                "            \"key\": \""+currentProjectKey+"\"" +
                "            }," +
                "        \"customfield_10104\":\""+epicName+"\"," +
                "        \"summary\": \""+summary+"\"," +
                "        \"reporter\": {" +
                "            \"name\":\""+reporterName+"\"" +
                "        } ," +
                "        \"issuetype\": {" +
                "            \"id\":"+currentProjectEpicId+" " +
                "        }" +
                "    }" +
                "}";
        Response response = issueAPI.postCreateEpic(epicObject);
        response.then().log().all().statusCode(201);
        assertEquals(response.getStatusCode(), 201);
    }
}
