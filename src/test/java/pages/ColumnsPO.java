package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ColumnsPO extends BasePO {
    @FindBy(xpath = "//label[normalize-space()='Simplified Workflow']")
    public WebElement workflowLabel;

    @FindBy(xpath = "//a[normalize-space()='Project Management Software']")
    public WebElement jiraLink;

    @FindBy(id = "about-link")
    public WebElement aboutLink;

    @FindBy(xpath = "//h3[normalize-space()='In Progress']//preceding-sibling::div")
    public WebElement inProgressColumn;

    @FindBy(xpath = "//h3[normalize-space()='To Do']//preceding-sibling::div")
    public WebElement toDoColumn;

    @FindBy(xpath = "//h3[normalize-space()='Resolved']//preceding-sibling::div")
    public WebElement resolvedColumn;

    @FindAll(@FindBy(xpath = "//div[@id='ghx-mapping-columns']//h3"))
    public List<WebElement> listOfStepColumnNames;

    @FindBy(id = "ghx-config-addcolumn")
    public WebElement addColumnButton;

    @FindBy(id = "back-to-board")
    public WebElement backToBoardButton;

    public void fixStepColumnOrder() throws InterruptedException {
        Point labelCoords = workflowLabel.getLocation();
        Point jiraLinkCoords = jiraLink.getLocation();
        Point aboutLinkCoords = aboutLink.getLocation();
        Actions actions = new Actions(driver);
            Thread.sleep(2000);
            actions.dragAndDropBy(toDoColumn, labelCoords.getX() - toDoColumn.getLocation().getX(), -10).perform();
            Thread.sleep(2000);
            actions.dragAndDropBy(inProgressColumn, (jiraLinkCoords.getX() - inProgressColumn.getLocation().getX()) - 50, -10).perform();
            Thread.sleep(2000);
            actions.dragAndDropBy(resolvedColumn, (aboutLinkCoords.getX() - resolvedColumn.getLocation().getX()), -10).perform();
    }

    public void addAndDeleteColumns() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<String> correctOrderList = new ArrayList<>();
        correctOrderList.add("To Do");
        correctOrderList.add("In Progress");
        correctOrderList.add("Resolved");
        correctOrderList.add("Closed");
        List<String> columnList = new ArrayList<>();
        for(WebElement column : listOfStepColumnNames) {
            columnList.add(column.getText());
        }
        for(int i = 0; i < columnList.size(); i++) {
            if(!correctOrderList.contains(columnList.get(i))) {
                driver.findElement(By.xpath("//div[@data-deleteindex='"+ i +"']")).click();
            }
        }
        List<WebElement> listAfterDeletion = driver.findElements(By.xpath("//div[@id='ghx-mapping-columns']//h3"));
        List<String> columnListAfterDeletion = new ArrayList<>();
        for(WebElement column : listAfterDeletion) {
            columnListAfterDeletion.add(column.getText());
        }
        for (String s : correctOrderList) {
            if (!columnListAfterDeletion.contains(s)) {
                addColumnButton.click();
                driver.findElement(By.xpath("//li[@class='ghx-header']/input")).clear();
                driver.findElement(By.xpath("//li[@class='ghx-header']/input")).sendKeys(s);
                driver.findElement(By.xpath("//li[@class='ghx-header']/input")).sendKeys(Keys.ENTER);
            }
        }
    }

    public void dragStatusToColumn() throws InterruptedException {
        List<WebElement> listOfStatuses = driver.findElements(By.xpath("//ul[@class='ghx-column-wrapper ghx-fixed-column ghx-config-status ghx-unmapped ui-sortable']//div[@class='ghx-lozenge-wrap']/span"));
        List<String> statusNames = new ArrayList<>();
        Actions actions = new Actions(driver);
        for(WebElement status : listOfStatuses) {
            statusNames.add((capitalizeWord(status.getText())));
        }
        for (String statusName : statusNames) {
            Thread.sleep(1000);
            actions.dragAndDrop(driver.findElement(By.xpath("//span[text()='" + statusName + "']")), driver.findElement(By.xpath("//h3[text()='" + statusName + "']"))).perform();
        }
    }

    public void clickBackToBoardButton () {backToBoardButton.click();}
}