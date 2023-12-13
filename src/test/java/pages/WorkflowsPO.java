package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkflowsPO extends BasePO {
    @FindBy(id = "add-workflow")
    public WebElement addWorkFlowButton;

    @FindBy(id = "add-workflow-newWorkflowName")
    public WebElement workflowNameInput;

    @FindBy(id = "add-workflow-submit")
    public WebElement addWorkFlowSubmitButton;

    public void clickAddWorkFlowButton() {addWorkFlowButton.click();}

    public void enterWorkflowNameInput(String workflowName) {workflowNameInput.sendKeys(workflowName);}

    public void clickAddWorkFlowSubmitButton() {addWorkFlowSubmitButton.click();}
}