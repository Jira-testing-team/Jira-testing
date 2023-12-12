package stepDef;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BoardPO;
import pages.DashboardPO;
import pages.LoginPO;

import java.sql.Driver;

public class ChangeIssueStatusStepsUI {
    private final LoginPO loginPO;
    private final DashboardPO dashboardPO;
    private final BoardPO boardPO;
    private final WebDriver driver;

    public ChangeIssueStatusStepsUI() {
        loginPO = new LoginPO();
        dashboardPO = new DashboardPO();
        boardPO = new BoardPO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in as a developer with {string} and {string}")
    public void iAmLoggedInAsADeveloperWithUsernameAndPassword(String username, String password) {
        loginPO.login(username, password);
    }

    @When("I am on the dashboard page and click the boards button and click on view all boards")
    public void iAmOnTheDashboardPageAndClickTheBoardsButtonAndClickOnViewAllBoards() {
        dashboardPO.clickBoardsButton();
        dashboardPO.clickViewAllBoardsButton();
    }

    @And("I select the project I am in and click on the jira issue by its {string} on the sprint board view")
    public void iSelectTheProjectIAmInAndClickOnTheJiraIssueByItsIssueNumberOnTheSprintBoardView(String number) {
        boardPO.clickFirstBoard();
        boardPO.clickSprintBoardButton();
        boardPO.clickJiraIssue(number);
    }

    @And("change the issue status from {string} to {string} then to Resolved")
    public void changeTheIssueStatusFromToThenTo(String toDo, String inProgress) {
        boardPO.clickIssueStep(toDo);
        boardPO.clickChangeIssueStatus();
        boardPO.clickIssueStep(inProgress);
        boardPO.clickChangeIssueStatus();
    }

    @Then("the status of the issue should be {string}")
    public void theStatusOfTheIssueShouldBe(String resolved) {
        Assert.assertEquals(boardPO.getIssueStatus(resolved), resolved);
    }

    @Given("I am logged in as a QA user with {string} and {string}")
    public void iAmLoggedInAsAQAUserWithUsernameAndPassword(String username, String password) {
        loginPO.login(username, password);
    }


    @When("I am on the dashboard page and click the boards button and select view all boards")
    public void iAmOnTheDashboardPageAndClickTheBoardsButtonAndSelectViewAllBoards() {
        dashboardPO.clickBoardsButton();
        dashboardPO.clickViewAllBoardsButton();
    }

    @And("I choose the project I am in and click on the jira issue by its {string} on the sprint board view")
    public void iChooseTheProjectIAmInAndClickOnTheJiraIssueByItsIssueNumberOnTheSprintBoardView(String number) {
        boardPO.clickFirstBoard();
        boardPO.clickSprintBoardButton();
        boardPO.clickJiraIssue(number);
    }

    @And("change the issue status from {string} to Canceled")
    public void changeTheIssueStatusFromTo(String resolved) {
        boardPO.clickIssueStep(resolved);
        boardPO.clickChangeIssueStatus();
    }

    @Then("the status should be {string}")
    public void theStatusShouldBe(String closed) {
        Assert.assertEquals(boardPO.getIssueStatus(closed), closed);
    }
}
