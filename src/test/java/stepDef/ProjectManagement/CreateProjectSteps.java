package stepDef.ProjectManagement;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPO;
import pages.LoginPO;
import pages.ProjectManagement.ProjectConfigPO;
import pages.ProjectManagement.ProjectPO;
import pages.ProjectManagement.ProjectPermissionPO;
import pages.ValidateCredentialPO;

import static org.testng.Assert.assertTrue;

public class CreateProjectSteps{
    //pages involved
    private LoginPO loginPO;
    private DashboardPO dashboardPO;
    private ProjectPO projectPO;
    private ProjectConfigPO projectConfigPO;
    private ProjectPermissionPO projectPermissionPO;
    private ValidateCredentialPO validateCredentialPO;
    private WebDriver driver;

    private final String newProjectName = "Scrum3";
    private final String newProjectKey = "SCRUM3";

    public CreateProjectSteps(){
        loginPO = new LoginPO();
        dashboardPO = new DashboardPO();
        projectPO = new ProjectPO();
        projectConfigPO = new ProjectConfigPO();
        projectPermissionPO = new ProjectPermissionPO();
        validateCredentialPO = new ValidateCredentialPO();
        driver = DriverFactory.getDriver();

    }

    @Given("I am logged in as admin and at the dashboard page")
    public void i_am_logged_in_as_admin_and_at_the_dashboard_page(){
        driver.navigate().to(loginPO.URL);
        loginPO.login("admin", "admin");
    }
    @When("I click on the Create Project in Projects drop down")
    public void i_click_on_the_create_project_in_projects_drop_down(){
        dashboardPO.clickProjectsBtn();
        dashboardPO.clickCreateProjectBtn();
    }
    @And("I select scrum type, workflow and I submit project Name, Key")
    public void i_select_scrum_type_workflow_and_i_submit_project_name_key(){
        dashboardPO.chooseScrum();
        dashboardPO.clickSelectProjectBtn();
        //This version works with firefox;
        //if with chrome, we cannot modify project key; the logic in next line must be changed
        dashboardPO.fillProjectNameAndKey(newProjectName, newProjectKey);
        dashboardPO.clickSubmitProjectBtn();
    }

    @Then("A new scrum project is created and I'm redirected to project's page")
    public void a_new_scrum_project_is_created_and_i_m_redirected_to_project_s_page(){
        driver.navigate().to(projectPO.URL+newProjectKey+"/summary");
        String boardTitle = projectPO.getBoardTitle();
        assertTrue(boardTitle.contains(newProjectKey));
    }

    @When("I click on Project Setting and go to permission setting")
    public void i_click_on_project_setting_and_go_to_permission_setting(){
        projectPO.clickConfigBtn();
//        driver.navigate().to(projectConfigPO.URL+newProjectKey+"/summary");
        projectConfigPO.clickPermissionBtn();
        projectConfigPO.clickPermissionActionBtn();
        projectConfigPO.clickSelectSchemeBtn();
    }

    @And("I enter password for admin verification")
    public void i_enter_password_for_admin_verification(){
        validateCredentialPO.enterPasswordInput("admin");
        validateCredentialPO.clickConfirm();
    }

    @And("I select \"Scrum Permission Schema\" in dropdown and click associate")
    public void selectScheme(){
        projectPermissionPO.selectScheme(driver, "Scrum Permission Schema");
    }

    @Then("The project is applied with an existing permission schema")
    public void checkScheme(){
        assertTrue(projectConfigPO.getCurrentSchemeName(driver).getText().equals("Scrum Permission Schema"));
    }



}
