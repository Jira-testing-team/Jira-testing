package stepDef.IssueManagement;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.IssueManagement.CreateIssuePO;
import pages.LoginPO;
import pages.ProjectManagement.ProjectBacklogPO;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateIssueSteps {

    private LoginPO loginPO;
    private ProjectBacklogPO projectBacklogPO;
    private CreateIssuePO createIssuePO;
    private WebDriver driver;
    private final String projectKey = "SCRUM3";
    private final String issueTitle = "Test";
    private final String priority = "Highest";
    private final String epicToLink = "Frontend";

    public CreateIssueSteps(){
        loginPO = new LoginPO();
        projectBacklogPO = new ProjectBacklogPO();
        createIssuePO = new CreateIssuePO();
        driver = DriverFactory.getDriver();
    }

    @And("I click on create issue in backlog and open it in a dialog")
    public void goToCreateIssue(){
        //no need to click when have 0 issue in project
//        projectBacklogPO.clickCreateIssueBtn();
        //TODO test not consistent when project has more than 1 issue; should improve rowsOfIssues
//        projectBacklogPO.clickOpenInDialogBtn();
    }

    @And("I submit info to create a new issue with detail settings")
    public void createIssue(){
        createIssuePO.setIssueSummary(issueTitle);
        createIssuePO.choosePriority(priority);
        createIssuePO.chooseEpicLink(epicToLink);
        createIssuePO.submit();
    }

    @Then("I can see a new issue \"Test\"")
    public void checkNewIssue(){
//        assertTrue(projectBacklogPO.checkIssueExist(driver, issueTitle));
//        assertEquals(projectBacklogPO.getIssueEpic(driver, issueTitle), epicToLink);
//        assertEquals(projectBacklogPO.getIssueLevel(driver, issueTitle), priority);

    }
}
