package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPO extends BasePO{
    public String URL = "http://localhost:8080/secure/Dashboard.jspa";
    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    private WebElement settingBtn;

    @FindBy(linkText = "User management")
    private WebElement userManagementBtn;

    @FindBy(xpath = "//a[@id=\"browse_link\"]/..")
    private WebElement projectsBtn;

    @FindBy(id = "project_template_create_link_lnk")
    private WebElement createProjectBtn;

    @FindBy(xpath = "//div[@title='Scrum software development']")
    private WebElement scrumBtn;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    private WebElement projectNextBtn;

    @FindBy(xpath = "//button[normalize-space()='Select']")
    private WebElement projectSelectBtn;

    @FindBy(id = "name")
    private WebElement projectNameInput;

    @FindBy(id = "key")
    private WebElement projectKeyInput;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement projectSubmitBtn;


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

    public void clickProjectsBtn() {projectsBtn.click();}

    public void clickCreateProjectBtn() {createProjectBtn.click();}

    public void chooseScrum() {
        scrumBtn.click();
        projectNextBtn.click();
    }
    public void clickSelectProjectBtn() {projectSelectBtn.click();}

    public void fillProjectNameAndKey(String name, String key){
        projectKeyInput.sendKeys(key);
        projectNameInput.sendKeys(name);

    }
    public void clickSubmitProjectBtn() {projectSubmitBtn.click();}
    public void clickIssuesButton() { issuesButton.click(); }

    public void clickBoardsButton() {boardsButton.click();}

    public void clickViewAllBoardsButton() {projectBoardButton.click();}
}

