package pages;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class MainPagePO extends BasePO{
    @FindBy(xpath = "//button[text()='Create sprint']")
    private WebElement createSprintBtn;

    @FindBy(linkText = "Backlog")
    private WebElement backlogBtn;

    @FindBy(id = "ghx-sprint-name")
    private WebElement sprintNameInput;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createBtn;

    @FindBy(xpath = "//div[@id='ghx-content-group']//div[@class='ghx-sprint-group']//button[@class='aui-button aui-button-subtle']")
    private WebElement createIssueBtn;

    @FindBy(xpath = "//div[@class='ghx-sprint-group']//textarea[@class='iic-widget__summary']")
    private WebElement issueTextBox;

    @FindBy(xpath = "//button[text()='Start sprint']")
    private WebElement startSprintBtn;

    @FindBy(xpath = "//button[text()='Start']")
    private WebElement startBtn;

    @FindBy(xpath = "//a[@data-label='Active sprints']")
    private WebElement activeSprintsBtn;

    @FindBy(xpath = "//div[@class='ghx-backlog-group']")
    private WebElement backlogGroup;

    @FindBy(xpath = "//div[@class='ghx-sprint-group']")
    private WebElement sprintGroup;

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmAddingIssueBtn;

    @FindBy(xpath = "//button[contains(@aria-label, 'More actions for')]")
    private WebElement moreActionsForSelectedIssue;

    @FindBy(linkText = "Edit")
    private WebElement editBtnForIssue;

    @FindBy(xpath = "//ul[@class='ghx-columns']")
    private WebElement allColumnsInActiveSprint;

    @FindBy(xpath = "//div[@class='ghx-backlog-container ghx-sprint-active js-sprint-container ghx-open ui-droppable']/descendant::div[@class='ghx-controls aui-group']")
    private WebElement threeDotsForActiveSprint;

    @FindBy(linkText = "Complete sprint")
    private WebElement completeSprintBtn;

    @FindBy(xpath = "//button[text()='Complete']")
    private WebElement confirmCompleteBtn;

    @FindBy(xpath = "//a[@data-label='Reports']")
    private WebElement reportsBtn;

    @FindBy(id = "subnav-trigger-reports")
    private WebElement switchReportBtn;

    @FindBy(linkText = "Velocity Chart")
    private WebElement velocityChartOption;

    @FindBy(id = "js-timeframe-value")
    private WebElement timeFrame;

    @FindBy(id = "js-apply-btn")
    private WebElement applyTimeFrameBtn;

    @FindBy(xpath = "//canvas")
    private WebElement reportCanvas;




    public void clickBacklog() { backlogBtn.click(); }

    public void clickCreate() {
        createSprintBtn.click();
    }
    public void createSprint(String name) {
        sprintNameInput.clear();
        sprintNameInput.sendKeys(name);
        sprintNameInput.sendKeys(Keys.RETURN);
        createBtn.click();
    }

    public void createIssueInSprint(String content) {
        createIssueBtn.click();
        issueTextBox.sendKeys(content);
        issueTextBox.sendKeys(Keys.RETURN);
    }

    public void clickStartSprintBtn() throws InterruptedException {
        Thread.sleep(3000);
        startSprintBtn.click();
    }

    public void clickStartBtn() {
        startBtn.click();
    }

    public void clickActiveSprintsBtn() {
        activeSprintsBtn.click();
    }

    public void clickCreateSprintBtn() {
        createSprintBtn.click();
    }

    public void dragIssueToSprint(WebElement issue, WebElement sprint) {
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(issue, sprint.findElement(By.xpath("./child::div[@class='ghx-meta']"))).build().perform();
        confirmAddingIssueBtn.click();
    }

    public WebElement getActiveSprint() {
        return sprintGroup.findElement(By.xpath("./child::div[@data-sprint-id][1]"));
    }

    public List<WebElement> sprintIssueList(String sprintName) {
        List<WebElement> result = new ArrayList<>();
        List<WebElement> sprints = sprintGroup.findElements(By.xpath("//div[contains(@class, 'js-sprint-container')]"));
        for(int i = 0; i < sprints.size(); i++) {
            WebElement sprint = sprintGroup.findElement(By.xpath("//div[contains(@class, 'js-sprint-container')][" + (i+1) + "]"));
            WebElement tmp = sprint.findElement(By.xpath("./descendant::span[@data-fieldName='sprintName']"));
            if(tmp.getText().equals(sprintName)) {
                WebElement level1 = sprint.findElement(By.xpath("./descendant::div[contains(@class, 'ghx-meta')]"));
                WebElement level2 = level1.findElement(By.xpath("./descendant::div[@class='ghx-issues js-issue-list ghx-has-issues']"));
                result = level2.findElements(By.xpath("./descendant::div[@data-issue-id]"));
            }
        }
        return result;
    }

    public WebElement getFirstIssueFromIssueList() {
        return backlogGroup.findElement(By.xpath("./descendant::div[@data-issue-id][1]"));
    }

    public void clickMoreActionsForSelectedIssue() {
        moreActionsForSelectedIssue.click();
    }

    public void clickEditBtnForIssue() {
        editBtnForIssue.click();
    }

    public List<WebElement> activeSprintIssueList() {
        WebDriver driver = DriverFactory.getDriver();
        List<WebElement> result = driver.findElements(By.xpath("//div[@data-issue-id]"));
        return result;
    }

    public void clickThreeDotsForActiveSprint() {
        threeDotsForActiveSprint.click();
    }

    public void clickCompleteSprintBtn() {
        completeSprintBtn.click();
    }

    public void clickConfirmCompleteBtn() {
        confirmCompleteBtn.click();
    }

    public void clickReportsBtn() {
        reportsBtn.click();
    }

    public void switchToVelocityChartReport() {
        switchReportBtn.click();
        velocityChartOption.click();
    }

    public void chooseTimeFrame(String number) {
        timeFrame.click();
        WebDriver driver = DriverFactory.getDriver();
        driver.findElement(By.xpath("//span[text()='"+number+" months']")).click();
        applyTimeFrameBtn.click();
    }

    public void downloadFromReportCanvas() {
        WebDriver driver = DriverFactory.getDriver();
        String dataURl = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].toDataURL('image/png');", reportCanvas);
        String base64Data = dataURl.split(",")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
        try (OutputStream stream = new FileOutputStream("canvas_image.png")) {
            stream.write(decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
