package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserBrowserPO extends BasePO {
    public String URL = "http://localhost:8080/secure/admin/user/UserBrowser.jspa";

    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login-form-submit']")
    public WebElement confirmButton;

    @FindBy(xpath = "//a[@id='group_browser']")
    public WebElement groupsButton;

    @FindBy(xpath = "//input[@id='user-filter-group-field']")
    public WebElement groupInput;

    @FindAll(@FindBy(xpath = "//div[@id='user-filter-group-suggestions']/div/ul/child::li"))
    public List<WebElement> listOfGroups;

    @FindBy(xpath = "//button[@id='user-filter-submit']")
    public WebElement filterButton;

    @FindAll(@FindBy(xpath = "//tbody/tr/child::td[4]/ul/li"))
    public List<WebElement> listOfUserGroups;

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickConfirmButton() { confirmButton.click(); }

    public void clickGroupsButton() {
        groupsButton.click();
    }

    public void enterGroupInput(String groupName) {
        groupInput.clear();
        groupInput.sendKeys(groupName);
    }

    public void clickGroupNameFromList(String groupName) {
        for(WebElement group : listOfGroups) {
            if(group.getText().equals(groupName)) {
                group.click();
            }
        }
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public List<String> getAllUserGroups() {
        List<String> result = new ArrayList<>();
        for(WebElement groupName : listOfUserGroups) {
            result.add(groupName.getText());
        }
        return result;
    }
}