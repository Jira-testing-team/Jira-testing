package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateIssuePO extends pages.BasePO{

    @FindBy(id = "issuetype-field")
    private WebElement issueTypeInput;

    @FindBy(id = "summary")
    private WebElement issueSummaryInput;

    @FindBy(id = "priority-field")
    private WebElement issuePriorityInput;

    @FindBy(id = "customfield_10110-field")
    private WebElement epicLinkInput;

    @FindBy(id = "create-issue-submit")
    private WebElement createIssueBtn;

    public void setIssueTypeInput(String type) throws InterruptedException {
        issueTypeInput.click();
        issueTypeInput.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        issueTypeInput.sendKeys(type);
        issueTypeInput.sendKeys(Keys.TAB);
    }
    public void setIssueSummary(WebDriver driver, String summary){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        issueSummaryInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));

        issueSummaryInput.click();
        issueSummaryInput.sendKeys(summary);
    }

    public void choosePriority(String level){
        //default is medium
        if(level.equals("Medium")){return;}
        issuePriorityInput.click();
        issuePriorityInput.findElement(By.xpath(".//following::a[normalize-space()='"+level+"']/..")).click();
    }

    public void chooseEpicLink(WebDriver driver, String epicName){
        new Actions(driver).scrollToElement(epicLinkInput);
        epicLinkInput.click();
        driver.findElement(By.xpath("//li[contains(@id, '"+epicName.toLowerCase()+"')]")).click();
    }

    public void submit(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        createIssueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-issue-submit")));
        createIssueBtn.click();
    }

}
