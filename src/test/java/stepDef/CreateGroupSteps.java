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

public class CreateGroupSteps {
    private final DashboardPO dashboardPO;
    private final UserManagementPO userBrowserPO;
    private final GroupBrowserPO groupBrowserPO;
    private final WebDriver driver;
    private final LoginPO loginPO;
    private final String username = "jzhang1297";
    private final String password = "Jia1997$";
    public String groupName = "abaca";

    public CreateGroupSteps() {
        dashboardPO = new DashboardPO();
        userBrowserPO = new UserManagementPO();
        groupBrowserPO = new GroupBrowserPO();
        loginPO = new LoginPO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in and on the dashboard page")
    public void iAmOnTheDashboardPage() {
        driver.navigate().to(loginPO.URL);
        loginPO.login(username, password);
    }


    @When("I click the config button")
    public void iClickTheConfigButton() {
        dashboardPO.clickSettingBtn();
    }

    @And("click on the user management button")
    public void clickOnTheUserManagementButton() {
        dashboardPO.clickUsermanagementBtn();
        userBrowserPO.enterPassword(password);
        userBrowserPO.clickConfirmButton();
    }

    @Then("I should be in the user browsers page")
    public void iShouldBeInTheUserBrowsersPage() {
        Assert.assertEquals(driver.getCurrentUrl(), userBrowserPO.URL);
    }

    @When("I click on the groups button")
    public void iClickOnTheGroupsButton() {
        userBrowserPO.clickGroupsButton();
    }

    @Then("I should be in the group browsers page")
    public void iShouldBeInTheGroupBrowsersPage() {
        Assert.assertEquals(driver.getCurrentUrl(), groupBrowserPO.URL);
    }

    @When("I enter the name of the group")
    public void iEnterTheNameOfTheGroup() {
        groupBrowserPO.enterGroupNameInput(groupName);
    }

    @And("click the add group button")
    public void clickTheAddGroupButton() {
        groupBrowserPO.clickAddGroupButton();
    }

    @Then("the name I just added should appear under group name")
    public void theNameIJustAddedShouldAppearUnderGroupName() {
        List<String> groupNames = groupBrowserPO.getGroupNames();
        for(String names : groupNames) {
            if(names.equals(groupName)) {
                Assert.assertEquals(names, groupName);
            }
        }
    }
}
