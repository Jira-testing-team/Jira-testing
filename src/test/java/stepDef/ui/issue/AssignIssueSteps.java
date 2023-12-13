package stepDef.ui.issue;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.IssuePO;
import pages.LoginPO;

import static org.testng.Assert.assertEquals;

public class AssignIssueSteps {

    private LoginPO loginPO;
    private IssuePO issuePO;
    private WebDriver driver;
    private final String issueKey = "SCRUM4-5";
    private final String userToAssign = "admin";

    public AssignIssueSteps(){
        loginPO = new LoginPO();
        issuePO = new IssuePO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in as admin and at the issue page")
    public void loginAtIssuePage() throws InterruptedException {
        driver.navigate().to(loginPO.URL);
        loginPO.slowLogin("admin", "admin");
        driver.navigate().to(issuePO.URL + issueKey);

    }

    @And("I click on assignee button and add an assignee")
    public void assignUser(){
        issuePO.inputAssignee(driver, userToAssign);
    }

    @Then("I can see the assignee updated")
    public void checkAssignSuccess(){
        assertEquals(issuePO.getAssignee(), userToAssign);
    }
}
