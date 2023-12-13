package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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
    //=====================================
    @FindBy(xpath = "//button[@class='aui-button aui-button-subtle']")
    private WebElement createIssueBtn;

    @FindBy(xpath = "//button[normalize-space()='Open in dialog']")
    private WebElement openInDialogBtn;

    private List<List<String>> rowsOfIssues;
    private List<String> rowsOfIssuesTitle;

    public void clickCreateIssueBtn(){createIssueBtn.click();}

    public void clickOpenInDialogBtn(){openInDialogBtn.click();}

    public boolean checkIssueExist(WebDriver driver, String issueTitle){
        //rowsOfIssues =
        rowsOfIssuesTitle = driver.findElements(By.xpath("//div[@class='ghx-row']"))
                .stream()
                .map(row -> {
                    String title = row.findElement(By.xpath("./div[@class='ghx-summary']")).getAttribute("title");
                    return title;
                })
                .collect(Collectors.toList());
        for(String s: rowsOfIssuesTitle){
            if(s.equals(issueTitle))
                return true;
        }
        return false;
    }

    public String getIssueLevel(WebDriver driver, String issueTitle){
        if(!checkIssueExist(driver, issueTitle)){
            return null;
        }else{
            for(List<String> l: rowsOfIssues){
                if(l.get(0).equals(issueTitle))
                    return l.get(1);
            }
        }
        return null;
    }

    public String getIssueEpic(WebDriver driver, String issueTitle){
        if(!checkIssueExist(driver, issueTitle)){
            return null;
        }else{
            for(List<String> l: rowsOfIssues){
                if(l.get(0).equals(issueTitle))
                    return l.get(2);
            }
        }
        return null;
    }

    //********
    //new create issue

    @FindBy(id = "create-menu")
    private WebElement topMenuCreateBtn;

    public void clickTopMenuCreateBtn(){topMenuCreateBtn.click();}


    //=====================================
    @FindBy(xpath = "//a[normalize-space()='Only My Issues']")
    private WebElement filterBtn;

    public void clickFilterBtn(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        filterBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Only My Issues']")));
        filterBtn.click();
    }
    public String getIssueKey(WebDriver driver){
        return driver.findElement(By.xpath("//div[@class=\"ghx-key\"]/a")).getText();
    }


}
