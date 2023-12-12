package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WorkflowStepEditPO extends BasePO {
    @FindBy(xpath = "//input[@name='stepName']")
    public WebElement stepNameInput;

    @FindBy(xpath = "//select[@name='stepStatus']")
    public WebElement statusDropDownMenu;

    @FindBy(id = "delete-workflow-submit")
    public WebElement updateButton;

    public void enterStepNameInput(String stepName) {
        stepNameInput.clear();
        stepNameInput.sendKeys(stepName);
    }

    public void selectStatus(String status) {
        Select dropdown = new Select(statusDropDownMenu);
        dropdown.selectByVisibleText(status);}

    public void clickUpdateButton() {updateButton.click();}
}