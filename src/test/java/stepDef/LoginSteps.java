package stepDef;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPO;

public class LoginSteps {
    private final LoginPO loginPO;
    private final WebDriver driver;
    private final String username = "jz";
    private final String password = "123";


    public LoginSteps() {
        loginPO = new LoginPO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.navigate().to(loginPO.URL);
    }

    @When("I enter the valid credentials")
    public void iEnterTheValidCredentials() {
        loginPO.enterUsername(username);
        loginPO.enterPassword(password);
    }

    @And("click the login button")
    public void clickTheLoginButton() {
        loginPO.clickLoginButton();
    }

    @Then("I should be directed to the dashboard page")
    public void iShouldBeDirectedToTheDashboardPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/secure/Dashboard.jspa");
    }

    @When("I enter the invalid credentials")
    public void iEnterTheInvalidCredentials() {
        loginPO.enterUsername("abababa");
        loginPO.enterPassword("123123123");
    }

    @Then("I should stay in the login page")
    public void iShouldStayInTheLoginPage() {
        Assert.assertEquals(driver.getCurrentUrl(), loginPO.URL);
    }
}
