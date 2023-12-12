package stepDef;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import static org.testng.Assert.*;

public class CreateUserSteps {
    private final LoginPO loginPO;
    private final DashboardPO dashboardPO;
    private final CreateUserPO createUserPO;
    private final UserManagementPO userManagementPO;
    private final ValidateCredentialPO validateCredentialPO;
    private final WebDriver driver;

    public CreateUserSteps() {
        loginPO = new LoginPO();
        dashboardPO = new DashboardPO();
        createUserPO = new CreateUserPO();
        userManagementPO = new UserManagementPO();
        validateCredentialPO = new ValidateCredentialPO();
        driver = DriverFactory.getDriver();
    }

    @Before
    public void setup() {
        driver.navigate().to("http://localhost:8080/secure/Dashboard.jspa");
    }

    @Given("I logged in as an admin")
    public void i_logged_in_as_an_admin() {
        loginPO.login("leozhu333", "password123");
    }
    @When("I click on setting on the dashboard page")
    public void i_click_on_setting_on_the_dashboard_page() {
        dashboardPO.clickSettingBtn();
    }
    @And("I click on User management")
    public void i_click_on_user_management() {
        dashboardPO.clickUsermanagementBtn();
    }
    @And("I enter credentials for administrator")
    public void i_enter_credentials_for_administratir() {
        validateCredentialPO.enterPasswordInput("password123");
        validateCredentialPO.clickConfirm();
    }
    @And("I click on Create user")
    public void i_click_on_create_user() {
        userManagementPO.clickCreate();
    }
    @And("I enter {string}, {string}, {string}, and {string}")
    public void i_fillout_the_information_for_the_new_user(String fullName, String email, String username, String password) {
        createUserPO.fillOut(email, fullName, username, password);
    }
    @And("I click on Create")
    public void i_click_on_create() {
        createUserPO.clickCreate();
    }
    @Then("The newly created user with {string} should be displayed in the user table")
    public void the_newly_created_user_should_be_displayed_in_the_user_table(String username) {
        assertTrue(userManagementPO.hasUser(username));
    }

//    @After
//    public void teardown() {
//        DriverFactory.teardown();
//    }
}
