package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssuesPO extends BasePO {
    @FindBy(id = "login-form-authenticatePassword")
    public WebElement passwordInput;

    @FindBy(id = "workflows")
    public WebElement workflowsButton;

    @FindBy(id = "login-form-submit")
    public WebElement confirmButton;

    @FindBy(id = "workflow_schemes")
    public WebElement workflowSchemesButton;

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickWorkflows() {workflowsButton.click();}

    public void clickConfirmButton() {confirmButton.click();}

    public void clickWorkflowSchemesButton() {workflowSchemesButton.click();}
}