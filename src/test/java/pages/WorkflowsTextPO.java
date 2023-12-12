package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WorkflowsTextPO extends BasePO {
    @FindBy(id = "edit_step_1")
    public WebElement firstStepEditButton;

    @FindBy(xpath = "//input[@name='stepName']")
    public WebElement stepNameInput;

    @FindBy(xpath = "//select[@name='stepStatus']")
    public WebElement statusDropDown;

    @FindBy(id = "workflow-step-add-submit")
    public WebElement addButton;

    @FindBy(id = "add_trans_1")
    public WebElement addTransitionButton1;

    @FindBy(id = "add_trans_2")
    public WebElement addTransitionButton2;

    @FindBy(id = "add_trans_3")
    public WebElement addTransitionButton3;

    @FindAll(@FindBy(xpath = "//td[1]/a"))
    List<WebElement> listOfStepNames;

    public void clickFirstStepEditButton() {firstStepEditButton.click();}

    public void enterStepNameInput(String stepName) {stepNameInput.sendKeys(stepName);}

    public void selectStatusDropDown(String statusName) {
        Select dropdown = new Select(statusDropDown);
        dropdown.selectByVisibleText(statusName);
    }

    public void clickAddButton() {addButton.click();}

    public void clickAddTransitionButton1() {addTransitionButton1.click();}

    public void clickAddTransitionButton2() {addTransitionButton2.click();}

    public void clickAddTransitionButton3() {addTransitionButton3.click();}

    public List<String> getListOfStepNames() {
        List<String> result = new ArrayList<>();
        for(WebElement stepName : listOfStepNames) {
            result.add(stepName.getText());
        }
        return result;
    }
}