package stepDef;

import api.GroupAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FilterUsersByGroupStepsAPI {
    public int statusCode;

    @When("I am logged in as an admin with {string} and {string} and fetch users by the group {string}")
    public void iAmLoggedInAsAnAdminWithUsernameAndPasswordAndFetchUsersByTheGroupGroupName(String username, String password, String groupName) {
        statusCode = new GroupAPI().getUsersFromGroup(username, password, groupName).statusCode();
    }

    @Then("I should receive a 200 status code")
    public void iShouldReceiveAStatusCode() {
        Assert.assertEquals(statusCode, 200);
    }
}
