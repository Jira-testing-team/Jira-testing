package stepDef.ProjectManagement;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LoginPO;
import pages.ProjectManagement.ProjectBacklogPO;

import static org.testng.Assert.assertTrue;

public class CreateEpicSteps {
    //pages involved

    private LoginPO loginPO;
    private ProjectBacklogPO projectBacklogPO;
    private WebDriver driver;
    private final String projectKey = "SCRUM3";
    private final String epicName = "Frontend";
    private final String epicSummary = "Frontend epic for test";

    public CreateEpicSteps() {
        this.loginPO = new LoginPO();
        this.projectBacklogPO = new ProjectBacklogPO();
        this.driver = DriverFactory.getDriver();
    }

    @Given("I am logged in as admin and at the project backlog page")
    public void loginAtProjectBacklog(){
        driver.navigate().to(loginPO.URL);
        loginPO.login("admin", "admin");
        driver.navigate().to(projectBacklogPO.URL_prefix + projectKey + projectBacklogPO.URL_suffix);
    }

    @And("I click on epic menu and epic button")
    public void goToEpicCreation(){
        projectBacklogPO.clickEpicMenuBtn();
        projectBacklogPO.clickEpicAddBtn(driver);
    }

    @And("I submit info to create a new epic and click create")
    public void createEpic(){
        projectBacklogPO.createNewEpic(epicName, epicSummary);
    }

    @Then("I can see a new epic \"Frontend\" in backlog page")
    public void checkEpicCreation(){
        assertTrue(epicName.contains(projectBacklogPO.getEpicName(driver)));
    }
}
