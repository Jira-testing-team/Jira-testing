package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class UserManagementPO extends BasePO{
    public String URL = "http://localhost:8080/secure/admin/user/UserBrowser.jspa";
    @FindBy(id = "create_user")
    private WebElement createBtn;

    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login-form-submit']")
    public WebElement confirmButton;

    @FindBy(xpath = "//a[@id='group_browser']")
    public WebElement groupsButton;

    @FindBy(id = "user_browser_table")
    private WebElement userTable;

    @FindBy(xpath = "//label[@for='user-edit-active']")
    private WebElement avtiveOption;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    private WebElement updateBtn;

    @FindBy(id = "user-filter-user-filter-active")
    private WebElement statusSelect;

    @FindBy(id = "user-filter-submit")
    private WebElement filterBtn;

    @FindBy(xpath = "//span[@class='aui-avatar aui-avatar-small']")
    private WebElement userProfile;

    @FindBy(linkText = "Log Out")
    private WebElement logoutBtn;

    @FindBy(id = "editgroups_jacky123")
    private WebElement editGroupsBtn;

    @FindBy(id = "groupsToJoin-textarea")
    private WebElement groupNameInput;

    @FindBy(id = "user-edit-groups-join")
    private WebElement joinBtn;

    @FindBy(xpath = "//div[@id='user-filter-group-suggestions']//ul//li")
    private WebElement QAOption;

    @FindAll(@FindBy(xpath = "//div[@id='user-filter-group-suggestions']/div/ul/child::li"))
    public List<WebElement> listOfGroups;

    @FindBy(xpath = "//b[text()='QA']")
    private WebElement QAOptionInAssign;

    @FindBy(id = "user-filter-group-field")
    private WebElement groupBox;



    public void clickCreate() {
        createBtn.click();
    }

    public boolean hasUser(String username) {
        List<WebElement> rows = userTable.findElements(By.xpath(".//tr"));
        for (int i = 0; i < rows.size(); i++) {
            String tmp = rows.get(i).findElement(By.xpath("//span[@class='username']")).getText();
            if(tmp.contains(username)) {
                return true;
            }
        }
        return false;
    }

    public void clickUserEdit(String username) {
        userTable.findElement(By.id("edituser_link_" + username)).click();
    }

    public void switchActive() {
        avtiveOption.click();
        updateBtn.click();
    }

    public void applyFilterByStatus(String status) throws InterruptedException {
        Thread.sleep(1000);
        Select select = new Select(statusSelect);
        if(status.equals("false")) {
            select.selectByValue("false");
        }else if(status.equals("true")) {
            select.selectByValue("true");
        }
        filterBtn.click();
    }

    public void clickLogout() {
        userProfile.click();
        logoutBtn.click();
    }

    public void clickUserdots(String username) {
        userTable.findElement(By.xpath("//tr[@data-user='" + username + "']/descendant::span[normalize-space()='Actions']")).click();
    }

    public void clickEditGroups() {
        editGroupsBtn.click();
    }

    public void assignGroups(String groupName) {
        groupNameInput.sendKeys(groupName);
        if(groupName.equals("QA")) {
            QAOptionInAssign.click();
        }
        joinBtn.click();
    }

    public void applyFilterByGroups(String group) {
        groupBox.clear();
        groupBox.sendKeys(group);
        QAOption.click();
        filterBtn.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickConfirmButton() { confirmButton.click(); }

    public void clickFilterButton() {
        filterBtn.click();
    }

    public void clickGroupsButton() {
        groupsButton.click();
    }

    public void enterGroupInput(String groupName) {
        groupBox.clear();
        groupBox.sendKeys(groupName);
    }

    public void clickGroupNameFromList(String groupName) {
        for(WebElement group : listOfGroups) {
            if(group.getText().equals(groupName)) {
                group.click();
            }
        }
    }

    public List<String> getAllUserGroups(String groupName) {
        List<String> result = new ArrayList<>();
        List<WebElement> list = driver.findElements(By.xpath("//td[@data-cell-type='user-groups']/ul/li/a[contains(text(), '"+ groupName +"')]"));
        for(WebElement group : list) {
            result.add(group.getText());
        }
        return result;
    }
}
