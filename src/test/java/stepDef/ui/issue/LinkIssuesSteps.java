package stepDef.ui.issue;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.IssuePO;
import pages.LoginPO;
import pages.ProjectBacklogPO;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LinkIssuesSteps {


    private LoginPO loginPO;
    private IssuePO issuePO;
    private ProjectBacklogPO projectBacklogPO;

    private WebDriver driver;
    private final String issueKey = "SCRUM4-6";
    private String tempIssueKey;
    private final String linkType = "is blocked by";

    public LinkIssuesSteps(){
        loginPO = new LoginPO();
        issuePO = new IssuePO();
        projectBacklogPO = new ProjectBacklogPO();
        driver = DriverFactory.getDriver();
    }

    @And("I click More dorpdown and click on Link")
    public void goToLinkIssues(){
        tempIssueKey = projectBacklogPO.getIssueKey(driver);
        assertNotNull(tempIssueKey);
        driver.navigate().to(issuePO.URL + issueKey);
        issuePO.goToLinkDialog();
    }

    @And("I choose link type 'blocked by', issue to link and submit")
    public void linkIssues(){
        issuePO.linkIssues(driver, linkType, tempIssueKey);
    }

    @Then("I can see a link that issue \"SCRUM3-17\" is blocked by another issue")
    public void checkLink(){
        assertTrue(issuePO.checkLink(driver, linkType, tempIssueKey));
    }
}
