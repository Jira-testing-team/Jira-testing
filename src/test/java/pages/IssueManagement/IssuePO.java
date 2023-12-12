package pages.IssueManagement;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssuePO extends pages.BasePO{
    public String URL = "http://localhost:8080/browse/";

    @FindBy(xpath = "//span[@id='assignee-val']/span[2]")
    private WebElement assigneeInputEnabler;
    @FindBy(id = "assignee-field")
    private WebElement assigneeInput;

    @FindBy(xpath = "//button[@class='aui-button submit']")
    private WebElement assigneeConfirmBtn;

    @FindBy(xpath = "//span[@id='assignee-val']/span")
    private WebElement assigneeSpan;

    @FindBy(id = "opsbar-operations_more")
    private WebElement moreBtn;

    @FindBy(id = "link-issue")
    private WebElement linkBtn;

    @FindBy(id = "link-type")
    private WebElement linkTypeSelect;

    @FindBy(id = "jira-issue-keys-multi-select")
    private WebElement linkTargetSelect;

    @FindBy(id = "jira-issue-keys-textarea")
    private WebElement linkTargetInput;


    public void inputAssignee(WebDriver driver, String username){
        new Actions(driver).moveToElement(assigneeSpan).perform();
        assigneeInputEnabler.click();
        assigneeInput.sendKeys(username);
        assigneeConfirmBtn.click();
    }

    public String getAssignee(){
        return assigneeSpan.getText();
    }

    public void goToLinkDialog(){
        moreBtn.click();
        linkBtn.click();
    }

    public void linkIssues(WebDriver driver, String linkType, String targetIssue){
        linkTypeSelect.findElement(By.xpath("./option[@value='"+linkType+"']")).click();
        linkTargetSelect.click();
        linkTargetInput.sendKeys(targetIssue);
        driver.findElement(By.xpath("//li[contains(@class, '"+targetIssue.toLowerCase()+"')]")).click();
        linkTargetInput.sendKeys(Keys.RETURN);
        //press return can replace clicking submit btn here
    }

    public boolean checkLink(WebDriver driver, String linkType, String targetIssue){
        String title = driver.findElement(By.xpath("//a[@class=\"issue-link link-title\"]")).getText();
        String type = driver.findElement(By.xpath("//dl[@class='links-list ']/dt")).getText();
        if(!title.equals(targetIssue)||!type.equals(linkType)){
            return false;
        }else{
            return true;
        }
    }
    //================
    @FindBy(id = "footer-comment-button")
    private WebElement commentBoxBtn;

//    @FindBy(xpath = "//iframe")
    private WebElement iframe;

    //"//body//p"
    //input comment inside iframe
    private WebElement commentInput;

    @FindBy(id = "issue-comment-add-submit")
    private WebElement commentAddSubmitBtn;

    //"//p[normalize-space()='12345']//following::a[@id='edit_comment_10100']"
    //a[start with edit]
    private WebElement commentEditBtn;

    //id="comment-edit-submit"
    private WebElement commentEditSubmitBtn;

    public void addComment(WebDriver driver, String content){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer-comment-button")));
        commentBoxBtn.click();
        iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        WebElement paragraph = driver.findElement(By.xpath("//body//p"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].textContent = arguments[1];", paragraph, content);

        driver.switchTo().defaultContent();
        jsExecutor.executeScript("arguments[0].removeAttribute('disabled');", commentAddSubmitBtn);
        commentAddSubmitBtn.click();
    }

    public void editComment(WebDriver driver, String content, String editContent){
        commentEditBtn = driver.findElement(By.xpath("//p[normalize-space()='"+content+"']//following::a[starts-with(@id, 'edit')]"));
        commentEditBtn.click();
        iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        WebElement paragraph = driver.findElement(By.xpath("//p[normalize-space()='"+content+"']"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].textContent = arguments[1];", paragraph, editContent);
        jsExecutor.executeScript("arguments[0].textContent = arguments[1].concat(arguments[0].textContent);", paragraph, editContent);
//        paragraph.sendKeys(Keys.RETURN, Keys.CONTROL);

        driver.switchTo().defaultContent();
        commentEditSubmitBtn = driver.findElement(By.id("comment-edit-submit"));
//        jsExecutor.executeScript("arguments[0].removeAttribute('disabled');", commentEditSubmitBtn);
        commentEditSubmitBtn.click();
        //TODO why is it not updated
    }

    public String getCommentContent(WebDriver driver){
        return driver.findElement(By.xpath("//div[starts-with(@id, 'comment')]//p")).getText();
    }



}
