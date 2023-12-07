package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GroupBrowserPO extends BasePO {
    public String URL = "http://localhost:8080/secure/admin/user/GroupBrowser.jspa";

    @FindBy(xpath = "//input[@name='addName']")
    public WebElement groupNameInput;

    @FindBy(xpath = "//input[@name='add_group']")
    public WebElement addGroupButton;

    @FindBy(xpath = "//a[@id='bulk_edit_groups']")
    public WebElement bulkEditButton;

    @FindAll(@FindBy(xpath = "//tbody/child::tr/td[1]"))
    public List<WebElement> groupNamesList;

    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login-form-submit']")
    public WebElement confirmButton;

    public void enterGroupNameInput(String name) {
        groupNameInput.sendKeys(name);
    }

    public void clickAddGroupButton() {
        addGroupButton.click();
    }

    public void clickBulkEditButton() {
        bulkEditButton.click();
    }

    public List<String> getGroupNames() {
        List<String> result = new ArrayList<>();
        for(WebElement webelement : groupNamesList) {
            result.add(webelement.getText());
        }
        return result;
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickConfirmButton() { confirmButton.click(); }
}