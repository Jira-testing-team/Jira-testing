package stepDef;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.LoginPO;
import pages.UserManagementPO;
import static org.testng.Assert.*;

public class DeactivateSteps {
    private UserManagementPO userManagementPO;
    private LoginPO loginPO;
    private WebDriver driver;

    public DeactivateSteps() {
        userManagementPO = new UserManagementPO();
        loginPO = new LoginPO();
        driver = DriverFactory.getDriver();
    }
    @And("I click on edit of the user with {string}")
    public void i_click_on_edit_of_the_user_with(String username) {
        userManagementPO.clickUserEdit(username);
    }
    @And("I uncheck the active option and click update")
    public void i_uncheck_the_active_option_and_click_update() {
        userManagementPO.switchActive();
    }
    @Then("I should be able to see user with {string} appears when I apply the filter of inactive users")
    public void i_should_be_able_to_see_this_user_appear_when_i_apply_the_filter_of_inactive_users(String username) throws InterruptedException {
        System.out.println("Apply filter");
        userManagementPO.applyFilterByStatus("false");
        System.out.println("Before assertion1");
        assertTrue(userManagementPO.hasUser(username));
        System.out.println("Assertion done");
    }
    @Then("This user cannot login with {string} and {string} anymore")
    public void this_user_cannot_login_anymore(String username, String password) throws InterruptedException {
        userManagementPO.clickLogout();
        Thread.sleep(3000);
        driver.navigate().to("http://localhost:8080/secure/Dashboard.jspa");
        Thread.sleep(3000);
        loginPO.login(username, password);
        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/secure/Dashboard.jspa"));

    }
}
