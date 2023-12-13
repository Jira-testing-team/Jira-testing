package stepDef.ui.sprint;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.MainPagePO;


import static org.testng.Assert.*;

public class MoveIssuesSteps {
    private MainPagePO mainPagePO;
    private String dataIssueID;
    private WebDriver driver;

    public MoveIssuesSteps() {
        mainPagePO = new MainPagePO();
        driver = DriverFactory.getDriver();
    }

    @And("I drag the first issue from backlog to a sprint")
    public void i_drag_the_first_issue_from_backlog_to_a_sprint() {
        mainPagePO.clickBacklog();
        WebElement firstIssueInBacklog = mainPagePO.getFirstIssueFromIssueList();
        dataIssueID = firstIssueInBacklog.getAttribute("data-issue-id");
        mainPagePO.dragIssueToSprint(firstIssueInBacklog, mainPagePO.getActiveSprint());
    }
    @Then("I should see the name of that sprint appears in the sprint field of the issue")
    public void i_should_see_the_name_of_that_sprint_appears_in_the_sprint_field_of_the_issue() {
        String expected = mainPagePO.getActiveSprint().findElement(By.xpath("./descendant::span[@data-fieldname='sprintName']")).getText();
        driver.findElement(By.xpath("//div[@data-issue-id='"+dataIssueID+"']")).click();
        driver.findElement(By.xpath("//dd[@id='issuekey-val']//a")).click();
        String actual = driver.findElement(By.xpath("//div[@id='customfield_10101-val']")).getText();
        actual = actual.trim();
        assertTrue(actual.contains(expected));

    }
}
