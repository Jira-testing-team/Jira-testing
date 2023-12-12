package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPO extends BasePO{
    public String URL = "http://localhost:8080/secure/Dashboard.jspa";
    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    private WebElement settingBtn;

    @FindBy(linkText = "User management")
    private WebElement userManagementBtn;

    @FindBy(id = "browse_link")
    private WebElement projectsBtn;

    @FindBy(id = "project_view_all_link_lnk")
    private WebElement viewAllProjectsBtn;

    public void clickSettingBtn() {
        settingBtn.click();
    }

    public void clickUsermanagementBtn() {
        userManagementBtn.click();
    }

    public void clickProjects() { projectsBtn.click(); }

    public void clickViewAllProjects() { viewAllProjectsBtn.click(); }
}

