package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserManagementPO extends BasePO{
    @FindBy(id = "create_user")
    private WebElement createBtn;

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



    public void clickCreate() {
        createBtn.click();
    }

    public boolean hasUser(String username) {
        List<WebElement> rows = userTable.findElements(By.xpath(".//tr"));
        for (int i = 0; i < rows.size(); i++) {
            String tmp = rows.get(i).findElement(By.xpath("//span[@class='username']")).getText();
            if(tmp.equals(username)) {
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

    public void applyInactiveFilter() throws InterruptedException {
        Thread.sleep(1000);
        Select select = new Select(statusSelect);
        select.selectByValue("false");
        filterBtn.click();
    }

    public void clickLogout() {
        userProfile.click();
        logoutBtn.click();
    }
}
