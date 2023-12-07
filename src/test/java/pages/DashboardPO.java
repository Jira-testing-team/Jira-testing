package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPO extends BasePO{
    public String URL = "http://localhost:8080/secure/Dashboard.jspa";
    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    private WebElement settingBtn;

    @FindBy(linkText = "User management")
    private WebElement userManagementBtn;

    public void clickSettingBtn() {
        settingBtn.click();
    }

    public void clickUsermanagementBtn() {
        userManagementBtn.click();
    }
}

