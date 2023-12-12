package stepDef;

import api.GroupAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class AddUserToGroupStepsAPI {
    public List<String> users;

    @When("I am logged in as an admin with {string} and {string} and add a user {string} to the {string} group")
    public void iAmLoggedInAsAnAdminWithUsernameAndPasswordAndAddAUserAddedUserToTheGroupNameGroup(String username, String password, String user, String groupName) {
        new GroupAPI().addUserToGroup(username, password, user, groupName);
    }

    @And("fetch a list of users from {string} using the same credentials {string} and {string}")
    public void fetchAListOfUsersFromGroupNameUsingTheSameCredentialsUsernameAndPassword(String groupName, String username, String password) {
        users = new GroupAPI().getUsersFromGroup(username, password, groupName).jsonPath().getList("values.name");
    }

    @Then("the user {string} I added should be in the list of users")
    public void theUserAddedUserIAddedShouldBeInTheListOfUsers(String user) {
        for(String username : users) {
            if(username.equals(user)) {
                Assert.assertEquals(username, user);
            }
        }
    }
}
