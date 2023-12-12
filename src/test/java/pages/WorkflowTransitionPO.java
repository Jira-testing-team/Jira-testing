package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WorkflowTransitionPO extends BasePO {
    @FindBy(xpath = "//input[@name='transitionName']")
    public WebElement transitionInput;

    @FindBy(xpath = "//select[@name='destinationStep']")
    public WebElement destinationDropdown;

    @FindBy(id = "add-workflow-submit")
    public WebElement addButton;

    public void enterTransitionInput(String transitionName) {transitionInput.sendKeys(transitionName);}

    public void selectDestinationDropdown(String destination) {
        Select dropdown = new Select(destinationDropdown);
        dropdown.selectByVisibleText(destination);}

    public void clickAddButton() {addButton.click();}
}