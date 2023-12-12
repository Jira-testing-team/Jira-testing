package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WorkflowSchemesPO extends BasePO {
    @FindBy(xpath = "(//a[text()='Edit'])[1]")
    public WebElement firstEditButton;

    @FindBy(id = "add-workflow-dropdown-trigger")
    public WebElement addWorkflowButton;

    @FindBy(id = "add-workflow")
    public WebElement addExistingWorkflowButton;

    @FindBy(id = "add-workflow-next")
    public WebElement workflowNextButton;

    @FindBy(id = "project-config-select-all-issue-types")
    public WebElement selectAllCheckbox;

    @FindBy(id = "assign-issue-types-submit")
    public WebElement finishButton;

    @FindBy(id = "publish-draft")
    public WebElement publishButton;

    @FindBy(id = "workflow-mapping-submit")
    public WebElement associateButton;

    @FindBy(id = "greenhopper_menu")
    public WebElement boardsButton;

    @FindBy(id = "ghx-manageviews-mlink_lnk")
    public WebElement projectBoardButton;

    public void clickEditButton() {firstEditButton.click();}

    public void clickAddWorkflowButton() {addWorkflowButton.click();}

    public void clickAddExistingWorkflowButton() {addExistingWorkflowButton.click();}

    public void scrollToWorkflowAndClick(String workflow) {
        WebElement workflowElement = driver.findElement(By.xpath("//li[text()='" + workflow + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", workflowElement);
        workflowElement.click();
    }

    public void clickWorkflowNextButton() {workflowNextButton.click();}

    public void clickSelectAllCheckbox() {selectAllCheckbox.click();}

    public void clickFinishButton() {finishButton.click();}

    public void clickPublishButton() {publishButton.click();}

    public void clickAssociateButton() {associateButton.click();}

    public void waitForAcknowledgeButtonAndClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement acknowledgeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("draft_acknowledge_submit")));
        acknowledgeButton.click();
    }

    public void clickBoardsButton() {boardsButton.click();}

    public void clickProjectBoardButton() {projectBoardButton.click();}
}