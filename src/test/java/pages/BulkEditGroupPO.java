package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BulkEditGroupPO extends BasePO {
    public String URL = "http://localhost:8080/secure/admin/user/BulkEditUserGroups!default.jspa";

    @FindBy(xpath = "//textarea[@id='selectedGroupsStr-textarea']")
    public WebElement groupInput;

    @FindBy(xpath = "//textarea[@id='usersToAssignStr']")
    public WebElement userAssignInput;

    @FindAll(@FindBy(xpath = "//div[@role='presentation']/ul/child::li"))
    public List<WebElement> groupList;

    @FindBy(xpath = "//input[@id='add-users-to-selected-groups']")
    public WebElement addUserButton;

    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    public WebElement passwordInput;

    @FindAll(@FindBy(xpath = "//optgroup/child::option"))
    public List<WebElement> groupMembersList;

    @FindBy(xpath = "//a[@id='user_browser']")
    public WebElement usersButton;

    public void enterGroupInput(String groupName) {
        groupInput.sendKeys(groupName);
    }

    public void enterUserAssignInput(String username) {
        userAssignInput.sendKeys(username);
    }

    public void clickGroupInList(String groupName) {
        for (WebElement webElement : groupList) {
            if (webElement.getText().contains(groupName)) {
                webElement.click();
            }
        }
    }

    public void clickAddUserButton() {
        addUserButton.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public List<String> getUserInGroupList() {
        List<String> result = new ArrayList<>();
        for(WebElement webElement : groupMembersList) {
            result.add(webElement.getText());
        }
        return result;
    }

    public void clickUsersButton() {
        usersButton.click();
    }
}