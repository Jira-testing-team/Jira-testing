package stepDef;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

import java.util.List;

public class AddUserToGroupStepsUI {
    private final GroupBrowserPO groupBrowserPO;
    private final BulkEditGroupPO bulkEditGroupPO;
    private final DashboardPO dashboardPO;
    private final UserManagementPO userManagementPO;
    private final WebDriver driver;
    private final LoginPO loginPO;

    public AddUserToGroupStepsUI() {
        groupBrowserPO = new GroupBrowserPO();
        bulkEditGroupPO = new BulkEditGroupPO();
        dashboardPO = new DashboardPO();
        userManagementPO = new UserManagementPO();
        loginPO = new LoginPO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in with {string} and {string} and on the group browser page")
    public void iAmOnTheGroupBrowserPage(String username, String password) {
        driver.navigate().to(loginPO.URL);
        loginPO.login(username, password);
        dashboardPO.clickSettingBtn();
        dashboardPO.clickUsermanagementBtn();
        groupBrowserPO.enterPassword(password);
        groupBrowserPO.clickConfirmButton();
        userManagementPO.clickGroupsButton();
    }

    @When("I click on bulk edit group members")
    public void iClickOnBulkEditGroupMembers() {
        groupBrowserPO.clickBulkEditButton();
    }

    @Then("I should be on the bulk edit group members page")
    public void iShouldBeOnTheBulkEditGroupMembersPage() {
        Assert.assertEquals(driver.getCurrentUrl(), bulkEditGroupPO.URL);
    }

    @When("I enter and select the name of the group, {string}")
    public void iSelectTheNameOfTheGroup(String groupName) {
        bulkEditGroupPO.enterGroupInput(groupName);
        bulkEditGroupPO.clickGroupInList(groupName);
    }

    @And("enter the user {string}, and click the add selected users button")
    public void enterTheUserAndClickTheAddSelectedUsersButton(String user) {
        bulkEditGroupPO.enterUserAssignInput(user);
        bulkEditGroupPO.clickAddUserButton();
    }

    @Then("the added user {string} should be under group members")
    public void theAddedUserShouldBeUnderGroupMembers(String user) {
        List<String> usernames = bulkEditGroupPO.getUserInGroupList();
        for(String name : usernames) {
            if(name.equals(user)) {
                Assert.assertEquals(name, user);
            }
        }
    }
}
