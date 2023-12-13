package stepDef.api.project;

import api.ProjectAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.testng.Assert.*;

public class AddUserToProjectAPISteps {
    private ProjectAPI projectAPI;
    private String currentProjectKey;

    public AddUserToProjectAPISteps(){
        projectAPI = new ProjectAPI();
    }


    @Given("I have project information of project {string}")
    public void getProjectInfo(String projectKey){
        Response response = projectAPI.getProject(projectKey);
        currentProjectKey = response.jsonPath().getString("key");
        response.then().log().all().statusCode(200);
        assertEquals(response.getStatusCode(), 200);
    }

    @Then("I can add user {string} to project as a role {string}")
    public void addUserToProject(String username, String role){
        int roleKey = 0;
        if(role.equals("developer")){roleKey = 10100;}
        String groupName = "jira-software-users";
        assertNotEquals(roleKey, 0);
        String usernameArr = "{\"user\":[\""+username+"\"]}, {\"groupName\":[\""+groupName+"\"]}";
        Response response = projectAPI.addUserToProject(currentProjectKey, roleKey, usernameArr);
        response.then().log().all().statusCode(200);
        assertEquals(response.getStatusCode(), 200);
    }



}
