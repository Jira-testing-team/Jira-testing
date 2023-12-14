package stepDef.api.issue;

import api.IssueAPI;
import api.SearchAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class CommentIssueAPISteps {
    private IssueAPI issueAPI;
    private SearchAPI searchAPI;
    private String username = "admin";
    private String issueKey;
    private String commentId;

    public CommentIssueAPISteps(){
        issueAPI = new IssueAPI();
        searchAPI = new SearchAPI();
    }

    @Given("I have a issue that can be viewed by the user \"developer\"")
    public void findIssueKey(){
        Response response = searchAPI.getAllStoriesByUsername(username);
        assertEquals(response.getStatusCode(), 200);
        issueKey = response.jsonPath().getString("issues[0].key");
    }

    @Then("I can comment on that issue")
    public void commentOnIssue(){
        String body = "{\"body\": \"add comment body\"}";
        Response response = issueAPI.postCreateComment(issueKey, body);
        assertEquals(response.getStatusCode(), 201);
        commentId = response.jsonPath().getString("id");
    }

    @Then("I can edit that comment")
    public void editComment(){
        String body = "{\"body\": \"edited\"}";
        Response response = issueAPI.putEditComment(issueKey, commentId, body);
        assertEquals(response.getStatusCode(), 200);
    }


}
