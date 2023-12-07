package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPO extends BasePO  {
    public String URL = "http://localhost:8080/secure/Dashboard.jspa";
    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    public WebElement configButton;

    @FindBy(xpath = "//a[@id='admin_users_menu']")
    public WebElement userManagementButton;

    public void clickConfigButton() {
        configButton.click();
    }

    public void clickUserManagementButton() {
        userManagementButton.click();
    }
}