package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkflowsDiagramPO extends BasePO {
    @FindBy(id = "workflow-text")
    public WebElement workflowTextButton;

    public void clickWorkflowTextButton() {workflowTextButton.click();}
}