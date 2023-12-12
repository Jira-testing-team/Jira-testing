package stepDef;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPO;
import pages.LoginPO;
import pages.UserManagementPO;

import java.util.List;

public class FilterUsersByGroupStepsUI {
    private final DashboardPO dashboardPO;
    private final UserManagementPO userBrowserPO;
    private final WebDriver driver;
    private final LoginPO loginPO;

    public FilterUsersByGroupStepsUI() {
        userBrowserPO = new UserManagementPO();
        dashboardPO = new DashboardPO();
        driver = DriverFactory.getDriver();
        loginPO = new LoginPO();
    }

    @Given("I am logged on with {string} and {string} and on the users browsers page")
    public void iAmOnTheUsersBrowsersPage(String username, String password) {
        driver.navigate().to(loginPO.URL);
        loginPO.login(username, password);
        dashboardPO.clickSettingBtn();
        dashboardPO.clickUsermanagementBtn();
        userBrowserPO.enterPassword(password);
        userBrowserPO.clickConfirmButton();
    }

    @When("I enter and select the group {string} I want to filter")
    public void iEnterAndSelectTheGroupIWantToFilter(String groupName) {
        userBrowserPO.enterGroupInput(groupName);
        userBrowserPO.clickGroupNameFromList(groupName);
    }

    @And("click on the filter button")
    public void clickOnTheFilterButton() {
        userBrowserPO.clickFilterButton();
    }

    @Then("I should see all users with the group {string} filter")
    public void iShouldSeeAllUsersWithTheGroupFilter(String groupName) {
        List<String> userGroups = userBrowserPO.getAllUserGroups(groupName);
        for(String group : userGroups) {
            Assert.assertEquals(group, groupName);
        }
    }
}
