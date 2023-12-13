package pages.IssueManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateIssuePO extends pages.BasePO{

    @FindBy(id = "summary")
    private WebElement issueSummaryInput;

    @FindBy(id = "priority-field")
    private WebElement issuePriorityInput;

    @FindBy(id = "customfield_10110-field")
    private WebElement epicLinkInput;

    @FindBy(id = "create-issue-submit")
    private WebElement createIssueBtn;


    public void setIssueSummary(String summary){
        issueSummaryInput.sendKeys(summary);
    }

    public void choosePriority(String level){
        issuePriorityInput.click();
        issuePriorityInput.findElement(By.xpath(".//following::a[normalize-space()='"+level+"']/..")).click();
    }

    public void chooseEpicLink(String epicName){
        epicLinkInput.click();
        epicLinkInput.findElement(By.xpath(".//following::a[contains(text(), '"+epicName+"')]/..")).click();
    }

    public void submit(){createIssueBtn.click();}

}
