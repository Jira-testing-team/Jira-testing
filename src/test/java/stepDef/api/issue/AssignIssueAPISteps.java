package stepDef.api.issue;

import api.IssueAPI;
import api.SearchAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class AssignIssueAPISteps {
    private SearchAPI searchAPI;
    private IssueAPI issueAPI;
    private String username = "developer";
    private String currentProjectKey = "SCRUMPROJ3";
    private String issueKey;

    public AssignIssueAPISteps(){
        searchAPI = new SearchAPI();
        issueAPI = new IssueAPI();
    }


    @Given("I have a issue and in the same project with the user \"developer\"")
    public void findIssueToAssign(){
        Response response = searchAPI.getAllStoriesByProject(currentProjectKey);
        assertEquals(response.getStatusCode(), 200);
        issueKey = response.jsonPath().getString("issues[0].key");

    }

    @Then("I can assign issue to the user \"developer\"")
    public void assignUser(){
        String body = "{\"name\": \""+username+"\"}";
        Response response = issueAPI.putAssignIssue(issueKey, body);
        response.then().log().all().statusCode(204);
        assertEquals(response.getStatusCode(), 204);
    }
}
