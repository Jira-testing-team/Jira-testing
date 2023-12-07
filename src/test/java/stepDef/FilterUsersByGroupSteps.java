package stepDef;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPO;
import pages.UserBrowserPO;

import java.util.List;

public class FilterUsersByGroupSteps {
    private final UserBrowserPO userBrowserPO;
    private final WebDriver driver;
    private final LoginPO loginPO;
    private final String username = "jz";
    private final String password = "123";

    public FilterUsersByGroupSteps() {
        userBrowserPO = new UserBrowserPO();
        driver = DriverFactory.getDriver();
        loginPO = new LoginPO();
    }

    @Given("I am logged on and on the users browsers page")
    public void iAmOnTheUsersBrowsersPage() {
        driver.navigate().to(loginPO.URL);
        loginPO.enterUsername(username);
        loginPO.enterPassword(password);
        loginPO.clickLoginButton();
        driver.navigate().to(userBrowserPO.URL);
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
