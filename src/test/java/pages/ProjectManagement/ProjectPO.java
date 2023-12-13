package pages.ProjectManagement;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPO extends pages.BasePO {
    //http://localhost:8080/projects/{ProjectKey}/summary

    public String URL = "http://localhost:8080/projects/";
    @FindBy(xpath = "//dd[@class='project-meta-value'][2]")
    private WebElement boardHeader;

    @FindBy(xpath = "//a[@class='aui-button aui-button-subtle aui-sidebar-settings-button']")
    private WebElement projectConfigBtn;

    public String getBoardTitle(){
        return boardHeader.getText();
    }

    public void clickConfigBtn(){
        projectConfigBtn.click();
    }



}
