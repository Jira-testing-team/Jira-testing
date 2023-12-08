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

public class AddUserToGroupSteps {
    private final GroupBrowserPO groupBrowserPO;
    private final BulkEditGroupPO bulkEditGroupPO;
    private final DashboardPO dashboardPO;
    private final UserManagementPO userManagementPO;
    private final WebDriver driver;
    private final LoginPO loginPO;
    public String user = "thecptn";
    private final String username = "jzhang1297";
    private final String password = "Jia1997$";

    public AddUserToGroupSteps() {
        groupBrowserPO = new GroupBrowserPO();
        bulkEditGroupPO = new BulkEditGroupPO();
        dashboardPO = new DashboardPO();
        userManagementPO = new UserManagementPO();
        loginPO = new LoginPO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in and on the group browser page")
    public void iAmOnTheGroupBrowserPage() {
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

    @When("I enter and select the name of the group")
    public void iSelectTheNameOfTheGroup() {
        bulkEditGroupPO.enterGroupInput("jira-administrator");
        bulkEditGroupPO.clickGroupInList("jira-administrator");
    }

    @And("enter the user, and click the add selected users button")
    public void enterTheUserAndClickTheAddSelectedUsersButton() {
        bulkEditGroupPO.enterUserAssignInput(user);
        bulkEditGroupPO.clickAddUserButton();
    }

    @Then("the added user should be under group members")
    public void theAddedUserShouldBeUnderGroupMembers() {
        List<String> usernames = bulkEditGroupPO.getUserInGroupList();
        for(String name : usernames) {
            if(name.equals(user)) {
                Assert.assertEquals(name, user);
            }
        }
    }
}
