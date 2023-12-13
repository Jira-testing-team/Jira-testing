package stepDef.api.issue;

import api.IssueLinkAPI;
import api.SearchAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class LinkIssueAPISteps {
    private IssueLinkAPI issueLinkAPI;
    private SearchAPI searchAPI;
    private String currentProjectKey = "SCRUMPROJ3";
    private String linkType = "Blocks";
    private String issue1Key;
    private String issue2Key;

    public LinkIssueAPISteps(){
        issueLinkAPI = new IssueLinkAPI();
        searchAPI = new SearchAPI();
    }

    @Given("I have the linkType and have two issues in a project")
    public void getIssuesFromProject(){
        Response response = searchAPI.getAllStoriesByProject(currentProjectKey);
        assertEquals(response.getStatusCode(), 200);
        issue1Key = response.jsonPath().getString("issues[0].key");
        issue2Key = response.jsonPath().getString("issues[1].key");
    }

    @Then("I can set issue1 to block issue2")
    public void blockIssues(){
        String issueLinkJSON = "{\n" +
                "    \"inwardIssue\": \n" +
                "    {\n" +
                "        \"key\": \""+issue1Key+"\"\n" +
                "    },\n" +
                "    \"outwardIssue\": {\n" +
                "        \"key\": \""+issue2Key+"\"\n" +
                "    },\n" +
                "    \"type\": {\n" +
                "        \"name\": \""+linkType+"\"\n" +
                "    }\n" +
                "}";
        Response response = issueLinkAPI.postCreateIssueLink(issueLinkJSON);
        response.then().log().all().statusCode(201);
        assertEquals(response.getStatusCode(), 201);

    }
}
