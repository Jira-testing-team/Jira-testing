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

public class FilterUsersByGroupSteps {
    private final DashboardPO dashboardPO;
    private final UserManagementPO userBrowserPO;
    private final WebDriver driver;
    private final LoginPO loginPO;
    private final String username = "jzhang1297";
    private final String password = "Jia1997$";

    public FilterUsersByGroupSteps() {
        userBrowserPO = new UserManagementPO();
        dashboardPO = new DashboardPO();
        driver = DriverFactory.getDriver();
        loginPO = new LoginPO();
    }

    @Given("I am logged on and on the users browsers page")
    public void iAmOnTheUsersBrowsersPage() {
        driver.navigate().to(loginPO.URL);
        loginPO.login(username, password);
        dashboardPO.clickSettingBtn();
        dashboardPO.clickUsermanagementBtn();
        userBrowserPO.enterPassword(password);
        userBrowserPO.clickConfirmButton();
    }

    @When("I enter and select the group I want to filter")
    public void iEnterAndSelectTheGroupIWantToFilter() {
        userBrowserPO.enterGroupInput("admin");
        userBrowserPO.clickGroupNameFromList("admin");
    }

    @And("click on the filter button")
    public void clickOnTheFilterButton() {
        userBrowserPO.clickFilterButton();
    }

    @Then("I should see all users with the group filter")
    public void iShouldSeeAllUsersWithTheGroupFilter() {
        List<String> userGroups = userBrowserPO.getAllUserGroups();
        for(String groupName : userGroups) {
            Assert.assertTrue(groupName.contains("admin"));
        }
    }
}
