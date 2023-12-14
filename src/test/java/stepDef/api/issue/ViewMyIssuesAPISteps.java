package stepDef.api.issue;

import api.SearchAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONArray;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class ViewMyIssuesAPISteps {
    private SearchAPI searchAPI;
    private String username = "admin";
    private List<String> issueList;

    public ViewMyIssuesAPISteps(){
        searchAPI = new SearchAPI();

    }

    @When("I search for all the issues assigned to me")
    public void useIssueSearch(){
        Response response = searchAPI.getAllStoriesByUsername(username);
        assertEquals(response.getStatusCode(), 200);
        issueList = response.jsonPath().getList("issues.fields.assignee.name", String.class);
    }


    @Then("I receive all the issues assigned to me")
    public void checkAllIssues(){
        System.out.print(issueList.get(0));
        for(int i=0; i<issueList.size(); i++){
            assertEquals(issueList.get(i), username);
        }
    }


}
