package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPO extends BasePO{
    public String URL = "http://localhost:8080/secure/Dashboard.jspa";
    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    private WebElement settingBtn;

    @FindBy(linkText = "User management")
    private WebElement userManagementBtn;

    @FindBy(id = "admin_issues_menu")
    public WebElement issuesButton;

    @FindBy(id = "greenhopper_menu")
    public WebElement boardsButton;

    @FindBy(id = "ghx-manageviews-mlink_lnk")
    public WebElement projectBoardButton;

    public void clickSettingBtn() {
        settingBtn.click();
    }

    public void clickUsermanagementBtn() {
        userManagementBtn.click();
    }

    public void clickIssuesButton() { issuesButton.click(); }

    public void clickBoardsButton() {boardsButton.click();}

    public void clickViewAllBoardsButton() {projectBoardButton.click();}
}

