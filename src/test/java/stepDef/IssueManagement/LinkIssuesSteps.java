package stepDef.IssueManagement;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.IssueManagement.IssuePO;
import pages.LoginPO;

import static org.testng.Assert.assertTrue;

public class LinkIssuesSteps {


    private LoginPO loginPO;
    private IssuePO issuePO;

    private WebDriver driver;
    private final String issueKey = "SCRUM3-17";
    private final String targetIssueKey = "SCRUM3-18";
    private final String linkType = "is blocked by";

    public LinkIssuesSteps(){
        loginPO = new LoginPO();
        issuePO = new IssuePO();
        driver = DriverFactory.getDriver();
    }

    @And("I click More dorpdown and click on Link")
    public void goToLinkIssues(){
        issuePO.goToLinkDialog();
    }

    @And("I choose link type 'blocked by', issue to link and submit")
    public void linkIssues(){
        issuePO.linkIssues(driver, linkType, targetIssueKey);
    }

    @Then("I can see a link that issue \"SCRUM3-17\" is blocked by \"SCRUM3-18\"")
    public void checkLink(){
        assertTrue(issuePO.checkLink(driver, linkType, targetIssueKey));
    }
}
