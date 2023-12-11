package pages.ProjectManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectConfigPO extends pages.BasePO{
    //http://localhost:8080/plugins/servlet/project-config/{ProjectKey}/summary
    public String URL = "http://localhost:8080/plugins/servlet/project-config/";
    @FindBy(xpath = "//a[@id='view_project_permissions']")
    private WebElement permissionTabBtn;
    @FindBy(xpath = "//a[@id='view_project_roles']")
    private WebElement UsersTabBtn;

    @FindBy(id = "project-config-tab-actions")
    private WebElement permissionActionBtn;

    @FindBy(xpath = "//a[@id='project-config-permissions-scheme-change']/..")
    private WebElement selectSchemeBtn;

    @FindBy(id = "project-config-scheme-name")
    private WebElement currentSchemeName;

    public void clickPermissionBtn(){permissionTabBtn.click(); }

    public void clickUsersBtn(){UsersTabBtn.click(); }

    public void clickPermissionActionBtn(){
        permissionActionBtn.click();
    }

    public void clickSelectSchemeBtn(){
        selectSchemeBtn.click();
    }

    public WebElement getCurrentSchemeName(WebDriver driver) {
        currentSchemeName = driver.findElement(By.id("project-config-scheme-name"));
        return currentSchemeName;
    }

}
