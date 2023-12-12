package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BoardPO extends BasePO {
    @FindBy(id = "board-tools-section-button")
    public WebElement boardButton;

    @FindBy(xpath = "//a[normalize-space()='Configure']")
    public WebElement configureButton;

    @FindBy(xpath = "//li[@class='aui-nav-selected']")
    public WebElement sprintBoardButton;

    @FindAll(@FindBy(xpath = "//h6"))
    public List<WebElement> columnList;

    @FindBy(id = "board1")
    public WebElement firstBoard;

    @FindBy(xpath = "//*[@id='opsbar-transitions_more_drop']/aui-section[1]")
    public WebElement changeIssueStatus;

    public void clickBoardButton() {boardButton.click();}

    public void clickConfigureButton() {configureButton.click();}

    public void clickSprintBoardButton() {sprintBoardButton.click();}

    public List<String> getColumnListAsString() {
        List<String> result = new ArrayList<>();
        for(WebElement column : columnList) {
            result.add(capitalizeWord(column.getText()));
        }
        return result;
    }

    public void clickFirstBoard() {firstBoard.click();}

    public void clickJiraIssue(String ticketNumber) {
        driver.findElement(By.xpath("//span[text()='-" + ticketNumber + "']")).click();
        driver.findElement(By.xpath("//a[contains(text(), '-" + ticketNumber + "')]")).click();
    }

    public void clickIssueStep(String stepName) {
        driver.findElement(By.xpath("//span[@class='dropdown-text'][text() = '" + stepName + "']")).click();
    }

    public void clickChangeIssueStatus() {
        changeIssueStatus.click();
    }

    public String getIssueStatus(String stepName) {
        return driver.findElement(By.xpath("//span[@class='dropdown-text'][normalize-space()='" + stepName + "']")).getText();
    }
}