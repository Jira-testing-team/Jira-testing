package stepDef.ui.sprint;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DashboardPO;
import pages.LoginPO;
import pages.MainPagePO;

import java.util.List;

import static org.testng.Assert.*;

public class ManageSprintSteps {
    private WebDriver driver;
    private MainPagePO mainPagePO;
    private LoginPO loginPO;
    private DashboardPO dashboardPO;

    public ManageSprintSteps() {
        driver = DriverFactory.getDriver();
        mainPagePO = new MainPagePO();
        loginPO = new LoginPO();
        dashboardPO = new DashboardPO();
    }

    @Given("I logged in as a team leader")
    public void i_logged_in_as_a_team_leader() {
        driver.navigate().to("http://localhost:8080/secure/Dashboard.jspa");
        loginPO.login("jason123", "test345");
    }
    @When("I nevigate to {string} projects page")
    public void i_nevigate_to_projects_page(String projectName) {
        dashboardPO.clickProjects();
        dashboardPO.clickViewAllProjects();
        driver.findElement(By.linkText(projectName)).click();
    }
    @And("I click on create sprint")
    public void i_click_on_create_sprint() {
        mainPagePO.clickBacklog();
        mainPagePO.clickCreateSprintBtn();
    }
    @And("I enter the {string} and click confirm")
    public void i_enter_the_and_click_confirm(String sprintName) {
        mainPagePO.createSprint(sprintName);
    }
    @And("I create an issue in that sprint")
    public void i_create_an_issue_in_that_sprint() {
        mainPagePO.createIssueInSprint("First issue");
    }
    @And("I click on start sprint")
    public void i_click_on_start_sprint() throws InterruptedException {
        mainPagePO.clickStartSprintBtn();
        mainPagePO.clickStartBtn();
    }
    @Then("I should be able to see {string} appears in the sprints group")
    public void i_should_be_able_to_see_appears_in_the_sprints_group(String sprintName) {
        mainPagePO.clickBacklog();
        WebElement sprintGroup = driver.findElement(By.xpath("//div[@class='ghx-sprint-group']"));
        List<WebElement> sprints = sprintGroup.findElements(By.xpath("./child::div[@data-sprint-id]"));
        boolean hasSprint = false;
        for(int i = 0; i < sprints.size(); i++) {
            WebElement sprint = sprintGroup.findElement(By.xpath("./child::div[@data-sprint-id][" + (i+1) + "]"));
            String name = sprint.findElement(By.xpath("./descendant::span[@data-fieldname='sprintName']")).getText();
            if(name.equals(sprintName)) {
                hasSprint = true;
                break;
            }
        }
        assertTrue(hasSprint);
    }
}
