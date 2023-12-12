package stepDef.ui.sprint;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPO;
import pages.MainPagePO;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ViewIssuesSteps {
    private MainPagePO mainPagePO;
    private LoginPO loginPO;
    private List<String> issueIdList;
    private WebDriver driver;

    public ViewIssuesSteps() {
        mainPagePO = new MainPagePO();
        loginPO = new LoginPO();
        driver = DriverFactory.getDriver();
        issueIdList = new ArrayList<>();
    }

    @And("I click on active sprints")
    public void I_click_on_active_sprints() {
        mainPagePO.clickBacklog();
        String sprintName = driver.findElement(By.xpath("//span[@data-fieldname='sprintName'][1]")).getText();
        List<WebElement> list = mainPagePO.sprintIssueList(sprintName);
        for (WebElement webElement : list) {
            issueIdList.add(webElement.getAttribute("data-issue-id"));
        }
        mainPagePO.clickActiveSprintsBtn();
    }

    @Then("I should all issues of that sprint displayed")
    public void I_should_all_issues_of_that_sprint_displayed() {
        List<WebElement> activeIssuelist = mainPagePO.activeSprintIssueList();
        for (WebElement webElement : activeIssuelist) {
            String id = webElement.getAttribute("id");
            if(issueIdList.contains(id)) {
                issueIdList.remove(id);
            }
        }
        assertTrue(issueIdList.size() == 0);
    }
}
