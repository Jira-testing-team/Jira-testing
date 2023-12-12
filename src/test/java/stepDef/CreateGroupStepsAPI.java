package stepDef;

import api.GroupAPI;
import api.GroupsAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class CreateGroupStepsAPI {
    public List<String> groupNames;

    @When("I am logged in as an admin with {string} and {string} and create a group with the name {string}")
    public void iAmLoggedInAsAnAdminWithUsernameAndPassword(String username, String password, String groupName) {
        new GroupAPI().createGroup(username, password, groupName);
    }

    @And("fetch a list of groups using the same credentials {string} and {string}")
    public void iCreateAGroupWithTheNameName(String username, String password) {
        groupNames = new GroupsAPI().getGroups(username, password).jsonPath().getList("groups.name");
    }

    @Then("my group {string} should be in the list of groups")
    public void whenIFetchTheGroupMyGroupNameShouldBeInTheListOfGroups(String groupName) {
        for(String name : groupNames) {
            if(name.equals(groupName)) {
                Assert.assertEquals(name, groupName);
            }
        }
    }
}
