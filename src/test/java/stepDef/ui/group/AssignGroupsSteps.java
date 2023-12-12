package stepDef.ui.group;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserManagementPO;
import static org.testng.Assert.*;

public class AssignGroupsSteps {
    private UserManagementPO userManagementPO;

    public AssignGroupsSteps() {
        userManagementPO = new UserManagementPO();
    }

    @When("I click on three dots of user with {string} and click edit user groups")
    public void i_click_on_three_dots_of_user_with_and_click_edit_user_groups(String username) {
        userManagementPO.clickUserdots(username);
        userManagementPO.clickEditGroups();
    }
    @And("I assign him to {string} group")
    public void i_assign_him_to_group(String group) {
        userManagementPO.assignGroups(group);
    }
    @Then("I should be able to see user with {string} appears when I apply the filter of {string} group")
    public void i_should_be_able_to_see_user_with_appears_when_i_apply_the_filter_of_group(String username, String group) {
        userManagementPO.applyFilterByGroups(group);
        assertTrue(userManagementPO.hasUser(username));
    }
}
