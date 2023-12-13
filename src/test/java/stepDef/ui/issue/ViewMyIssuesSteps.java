package stepDef.ui.issue;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPO;
import pages.ProjectBacklogPO;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ViewMyIssuesSteps {
    private WebDriver driver;
    private LoginPO loginPO;
    private ProjectBacklogPO projectBacklogPO;
    private final String currentUsername = "admin";
    private final String myIssueKey = "SCRUM4-5";

    public ViewMyIssuesSteps(){
        driver = DriverFactory.getDriver();
        loginPO = new LoginPO();
        projectBacklogPO = new ProjectBacklogPO();
    }

    @And("I click on filter \"Only my issues\"")
    public void clickFilter(){
        projectBacklogPO.clickFilterBtn(driver);}

    @Then("I can view all the issues assigned to me")
    public void checkIssueKey(){
        assertEquals(projectBacklogPO.getIssueKey(driver), myIssueKey);
    }
}
