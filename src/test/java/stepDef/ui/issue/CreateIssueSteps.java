package stepDef.ui.issue;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CreateIssuePO;
import pages.LoginPO;
import pages.ProjectBacklogPO;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateIssueSteps {

    private LoginPO loginPO;
    private ProjectBacklogPO projectBacklogPO;
    private CreateIssuePO createIssuePO;
    private WebDriver driver;
    private final String projectKey = "SCRUM4";
    private final String issueTitle = "Test";
    private final String priority = "Highest";
    private final String epicToLink = "Frontend";

    public CreateIssueSteps(){
        loginPO = new LoginPO();
        projectBacklogPO = new ProjectBacklogPO();
        createIssuePO = new CreateIssuePO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in as admin and at the project backlog page")
    public void loginAtProjectBacklog() throws InterruptedException {
        driver.navigate().to(loginPO.URL);
        loginPO.slowLogin("admin", "admin");
        driver.navigate().to(projectBacklogPO.URL_prefix + projectKey + projectBacklogPO.URL_suffix);
    }
    @And("I click on the create button at header menu")
    public void goToCreateIssue(){
        projectBacklogPO.clickTopMenuCreateBtn();
    }
    @And("I set type to \"story\" and submit {string}, {string}, {string} to create a new issue with detail settings")
    public void createIssue(String issueTitle, String priority, String epicName) throws InterruptedException {
        createIssuePO.setIssueTypeInput("Story");
        createIssuePO.setIssueSummary(driver, issueTitle);
        createIssuePO.choosePriority(priority);
        if(!epicName.equals("")){
            createIssuePO.chooseEpicLink(driver, epicName);
        }
        createIssuePO.submit(driver);
    }

    @Then("I can see a new issue {string}")
    public void checkNewIssue(String title){
        assertTrue(projectBacklogPO.checkIssueExist(driver, title));
    }

    @After
    public void teardown() {
        DriverFactory.teardown();
    }
}
