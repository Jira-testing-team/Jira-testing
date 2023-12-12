package pages.ProjectManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class ProjectBacklogPO extends pages.BasePO{
    //http://localhost:8080/secure/RapidBoard.jspa?projectKey={ProjectKey}&view=planning
    public String URL_prefix = "http://localhost:8080/secure/RapidBoard.jspa?projectKey=";
    public String URL_suffix = "&view=planning";
    @FindBy(xpath = "//li[@class='js-epic-toggle ghx-epic-toggle']")
    private WebElement epicMenuBtn;

    @FindBy(xpath = "//div[@class='ghx-classification-header']")
    private WebElement epicHeader;

    @FindBy(xpath = "//button[@title='Create epic']")
    private WebElement epicAddBtn;

    @FindBy(id = "customfield_10104")
    private WebElement epicNameInput;

    @FindBy(id = "summary")
    private WebElement summaryInput;

    @FindBy(id = "create-issue-submit")
    private WebElement createBtn;

    public void clickEpicMenuBtn(){epicMenuBtn.click();}

    public void clickEpicAddBtn(WebDriver driver){
        Actions action = new Actions(driver);
        action.moveToElement(epicHeader).perform();
        epicAddBtn.click();
    }

    public void createNewEpic(String epicName, String epicSummary){
        epicNameInput.sendKeys(epicName);
        summaryInput.sendKeys(epicSummary);
        createBtn.click();
    }

    public String getEpicName(WebDriver driver){
        return driver.findElement(By.xpath("//span[@data-fieldname='epicLabel']")).getText();
    }
}
