package stepDef;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class EditColumnsStepsUI {
    private final LoginPO loginPO;
    private final DashboardPO dashboardPO;
    private final IssuesPO issuesPO;
    private final WorkflowSchemesPO workflowSchemesPO;
    private final BoardPO boardPO;
    private final ConfigurationPO configurationPO;
    private final ColumnsPO columnsPO;
    private final WebDriver driver;

    public EditColumnsStepsUI() {
        loginPO = new LoginPO();
        dashboardPO = new DashboardPO();
        issuesPO = new IssuesPO();
        workflowSchemesPO = new WorkflowSchemesPO();
        boardPO = new BoardPO();
        configurationPO = new ConfigurationPO();
        columnsPO = new ColumnsPO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in with {string} and {string}")
    public void iAmLoggedInWithUsernameAndPassword(String username, String password) {
        loginPO.login(username, password);
    }

    @When("I am on the dashboard page and click settings button and click issues button")
    public void iAmOnTheDashboardPageAndClickSettingsButtonAndClickIssuesButton() {
        dashboardPO.clickSettingBtn();
        dashboardPO.clickIssuesButton();
    }

    @And("authenticate with my {string} and click confirm button")
    public void authenticateWithMyPasswordAndClickConfirmButton(String password) {
        issuesPO.enterPassword(password);
        issuesPO.clickConfirmButton();
    }

    @And("click on workflow schemes button")
    public void clickOnWorkflowSchemesButton() {
        issuesPO.clickWorkflowSchemesButton();
    }

    @And("click on edit button for the first project")
    public void clickOnEditButtonForTheFirstProject() {
        workflowSchemesPO.clickEditButton();
    }

    @And("click on add workflow button and click on add existing button")
    public void clickOnAddWorkflowButtonAndClickOnAddExistingButton() {
        workflowSchemesPO.clickAddWorkflowButton();
        workflowSchemesPO.clickAddExistingWorkflowButton();
    }

    @And("scroll until {string} is present and click on it")
    public void scrollUntilWorkflowNameIsPresentAndClickOnIt(String workflowName) {
        workflowSchemesPO.scrollToWorkflowAndClick(workflowName);
    }

    @And("click on the next button and check select all to assign workflow to all issues")
    public void clickOnTheNextButtonAndCheckSelectAllToAssignWorkflowToAllIssues() {
        workflowSchemesPO.clickWorkflowNextButton();
        workflowSchemesPO.clickSelectAllCheckbox();
    }

    @And("click finish button and click publish button")
    public void clickFinishButtonAndClickPublishButton() {
        workflowSchemesPO.clickFinishButton();
        workflowSchemesPO.clickPublishButton();
    }

    @And("click Associate button and wait until acknowledge button is present then click it")
    public void clickAssociateButtonAndWaitUntilAcknowledgeButtonIsPresentThenClickIt() {
        workflowSchemesPO.clickAssociateButton();
        workflowSchemesPO.waitForAcknowledgeButtonAndClick();
    }

    @And("click boards and click on the first project")
    public void clickBoardsAndClickOnTheFirstProject() {
        workflowSchemesPO.clickBoardsButton();
        workflowSchemesPO.clickProjectBoardButton();
        boardPO.clickFirstBoard();
    }

    @And("click on the sprint board view on the board page")
    public void clickOnTheSprintBoardViewOnTheBoardPage() {
        boardPO.clickSprintBoardButton();
    }

    @And("click on board and select configure")
    public void clickOnBoardAndSelectConfigure() {
        boardPO.clickBoardButton();
        boardPO.clickConfigureButton();
    }

    @And("click on columns and check to see if the steps are correct and present")
    public void clickOnColumnsAndCheckToSeeIfTheStepsAreCorrectAndPresent() {
        configurationPO.clickColumnsButton();
    }

    @And("add and delete columns as necessary to the workflow structure")
    public void addDeleteColumnsAsNecessaryToTheWorkflowStructure() {
        columnsPO.addAndDeleteColumns();
    }

    @And("drag and drop the columns to the correct order")
    public void dragAndDropTheColumnsToTheCorrectOrder() throws InterruptedException {
        columnsPO.fixStepColumnOrder();
    }

    @And("drag and drop the statuses under unmapped statuses to their correct column")
    public void dragAndDropTheStatusesUnderUnmappedStatusesToTheirCorrectColumn() throws InterruptedException {
        columnsPO.dragStatusToColumn();
    }

    @And("click back to board")
    public void clickBackToBoard() {
        columnsPO.clickBackToBoardButton();
        boardPO.clickSprintBoardButton();
    }

    @Then("the order of the columns we edited should appear correctly with the issues shown below")
    public void theOrderOfTheColumnsWeEditedShouldAppearCorrectlyWithTheIssuesShownBelow() {
        List<String> expectedResults = new ArrayList<>();
        List<String> actualResults = boardPO.getColumnListAsString();
        expectedResults.add("To Do");
        expectedResults.add("In Progress");
        expectedResults.add("Resolved");
        expectedResults.add("Closed");
        for(int i = 0; i < actualResults.size(); i++) {
            Assert.assertEquals(actualResults.get(i), expectedResults.get(i));
        }
    }
}
