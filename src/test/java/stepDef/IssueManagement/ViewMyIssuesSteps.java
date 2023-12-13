package stepDef.IssueManagement;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LoginPO;
import pages.ProjectManagement.ProjectBacklogPO;

import static org.testng.Assert.assertEquals;

public class ViewMyIssuesSteps {
    private WebDriver driver;
    private LoginPO loginPO;
    private ProjectBacklogPO projectBacklogPO;
    private final String currentUsername = "admin";
    private final String myIssueKey = "SCRUM3-18";

    public ViewMyIssuesSteps(){
        driver = DriverFactory.getDriver();
        loginPO = new LoginPO();
        projectBacklogPO = new ProjectBacklogPO();
    }

    @And("I click on filter \"Only my issues\"")
//    public void clickFilter(){projectBacklogPO.clickFilterBtn();}

    @Then("I can view all the issues assigned to me")
    public void checkIssueKey(){
//        assertEquals(myIssueKey, projectBacklogPO.getIssueKey(driver));
    }
}
