package stepDef.ui.workflow;

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

public class CreateWorkflowStepsUI {
    private final DashboardPO dashboardPO;
    private final IssuesPO issuesPO;
    private final WorkflowsPO workflowsPO;
    private final WorkflowsDiagramPO workflowsDiagramPO;
    private final WorkflowsTextPO workflowsTextPO;
    private final WorkflowStepEditPO workflowStepEditPO;
    private final WorkflowTransitionPO workflowTransitionPO;
    private final LoginPO loginPO;
    private final WebDriver driver;

    public CreateWorkflowStepsUI() {
        dashboardPO = new DashboardPO();
        issuesPO = new IssuesPO();
        workflowsPO = new WorkflowsPO();
        workflowsDiagramPO = new WorkflowsDiagramPO();
        workflowsTextPO = new WorkflowsTextPO();
        workflowStepEditPO = new WorkflowStepEditPO();
        workflowTransitionPO = new WorkflowTransitionPO();
        loginPO = new LoginPO();
        driver = DriverFactory.getDriver();
    }

    @Given("I logged in as an admin with {string} and {string}")
    public void iLoggedInAsAnAdminWithUsernameAndPassword(String username, String password) {
        loginPO.login(username, password);
    }

    @When("I am on the dashboard page and click on the settings then issues button")
    public void iAmOnTheDashboardPageAndClickOnTheSettingsThenIssuesButton() {
        dashboardPO.clickSettingBtn();
        dashboardPO.clickIssuesButton();
    }

    @And("authenticate with my {string} and click confirm")
    public void authenticateWithMyPasswordAndClickConfirm(String password) {
        issuesPO.enterPassword(password);
        issuesPO.clickConfirmButton();
    }

    @And("click on the workflows button and click on add workflow")
    public void clickOnTheWorkflowsButtonAndClickOnAddWorkflow() {
        issuesPO.clickWorkflows();
        workflowsPO.clickAddWorkFlowButton();
    }

    @And("enter a name {string} for my workflow and click add")
    public void enterANameWorkflowNameForMyWorkflowAndClickAdd(String workflowName) {
        workflowsPO.enterWorkflowNameInput(workflowName);
        workflowsPO.clickAddWorkFlowSubmitButton();

    }

    @And("click on the text view button for workflow")
    public void clickOnTheTextViewButtonForWorkflow() {
        workflowsDiagramPO.clickWorkflowTextButton();
    }

    @And("click on edit for my first step Open")
    public void clickOnEditForMyFirstStep() {
        workflowsTextPO.clickFirstStepEditButton();
    }

    @And("change the input and select the dropdown value from Open to {string}")
    public void changeTheInputAndSelectTheDropdownValueFromTo(String toDo) {
        workflowStepEditPO.enterStepNameInput(toDo);
        workflowStepEditPO.selectStatus(toDo);
    }

    @And("click Update and enter and select value {string} for input and dropdown and click add")
    public void clickUpdateAndEnterAndSelectValueForInputAndDropdownAndClickAdd(String inProgress) {
        workflowStepEditPO.clickUpdateButton();
        workflowsTextPO.enterStepNameInput(inProgress);
        workflowsTextPO.selectStatusDropDown(inProgress);
        workflowsTextPO.clickAddButton();
    }

    @And("enter and select resolved value {string} for input and dropdown and click add")
    public void enterAndSelectValueForInputAndDropdownAndClickAdd(String resolved) {
        workflowsTextPO.enterStepNameInput(resolved);
        workflowsTextPO.selectStatusDropDown(resolved);
        workflowsTextPO.clickAddButton();
    }

    @And("enter and select closed value {string} for input and dropdown and click add")
    public void enterAndSelectClosedValueForInputAndDropdownAndClickAdd(String closed) {
        workflowsTextPO.enterStepNameInput(closed);
        workflowsTextPO.selectStatusDropDown(closed);
        workflowsTextPO.clickAddButton();
    }

    @And("click add transition for To Do")
    public void clickAddTransitionForToDo() {
        workflowsTextPO.clickAddTransitionButton1();
    }

    @And("enter transition {string} in input and select the destination {string} in dropdown and click add")
    public void enterTransitionWorkBeginInInputAndSelectTheDestinationInDropdownAndClickAdd(String workBegin, String inProgress) {
        workflowTransitionPO.enterTransitionInput(workBegin);
        workflowTransitionPO.selectDestinationDropdown(inProgress);
        workflowTransitionPO.clickAddButton();
    }

    @And("click add transition for In Progress")
    public void clickAddTransitionForInProgress() {
        workflowsTextPO.clickAddTransitionButton2();
    }

    @And("enter transition {string} in input, and select the destination {string} in dropdown and click add")
    public void enterTransitionIssueFixedInInputAndSelectTheDestinationInDropdownAndClickAdd(String issueFixed, String resolved) {
        workflowTransitionPO.enterTransitionInput(issueFixed);
        workflowTransitionPO.selectDestinationDropdown(resolved);
        workflowTransitionPO.clickAddButton();
    }


    @And("click add transition for Resolved")
    public void clickAddTransitionForResolved() {
        workflowsTextPO.clickAddTransitionButton3();
    }

    @And("enter transition {string} in input and select the destination {string} in dropdown, and click add")
    public void enterTransitionClosedOutInInputAndSelectTheDestinationInDropdownAndClickAdd(String closingOut, String closed) {
        workflowTransitionPO.enterTransitionInput(closingOut);
        workflowTransitionPO.selectDestinationDropdown(closed);
        workflowTransitionPO.clickAddButton();
    }

    @Then("my workflow structure should match the sequential order of the step names")
    public void myWorkflowStructureShouldMatchTheSequentialOrderOfTheStepNames() {
        List<String> expectedStepsList = new ArrayList<>();
        List<String> actualStepsList = workflowsTextPO.getListOfStepNames();
        expectedStepsList.add("To Do");
        expectedStepsList.add("In Progress");
        expectedStepsList.add("Resolved");
        expectedStepsList.add("Closed");
        if(expectedStepsList.size() == actualStepsList.size()) {
            for(int i = 0; i < expectedStepsList.size(); i++) {
                Assert.assertEquals(actualStepsList.get(i), expectedStepsList.get(i));
            }
        } else {
            Assert.fail();
        }
    }
}
