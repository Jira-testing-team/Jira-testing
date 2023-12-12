package stepDef.ProjectManagement;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LoginPO;
import pages.ProjectManagement.ProjectConfigPO;
import pages.ProjectManagement.ProjectPO;
import pages.ProjectManagement.ProjectUsersPO;

import static org.testng.AssertJUnit.assertTrue;

public class AddUserToProjectSteps {
    //pages involved
    private LoginPO loginPO;
    private ProjectPO projectPO;

    private ProjectConfigPO projectConfigPO;

    private ProjectUsersPO projectUsersPO;
    private WebDriver driver;

    private final String projectKey = "SCRUM3";
    private final String userName = "lead";
    private final String role = "Team lead";

    public AddUserToProjectSteps(){
        loginPO = new LoginPO();
        projectPO = new ProjectPO();
        projectConfigPO = new ProjectConfigPO();
        projectUsersPO = new ProjectUsersPO();
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in as admin and at the project summary page")
    public void loginAtProject(){
        driver.navigate().to(loginPO.URL);
        loginPO.login("admin", "admin");
        driver.navigate().to(projectPO.URL+projectKey+"/summary");
    }

    @And("I click on project config and go to project users and roles page")
    public void goToUsersTab(){
        projectPO.clickConfigBtn();
        projectConfigPO.clickUsersBtn();
    }

    @And("I add a user \"lead\" to the role \"Team lead\"")
    public void addUserByNameToRole(){
        projectUsersPO.clickAddBtn();
        projectUsersPO.addUser(userName, role);

    }

    @Then("I can see the user \"lead\" in this project")
    public void checkUserAddedWithRole(){
        assertTrue(projectUsersPO.checkUserByName(userName));
        assertTrue(projectUsersPO.getUserRole(userName).contains(role));
    }

}
