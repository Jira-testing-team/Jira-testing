package stepDef.api.project;

import api.ProjectAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.Builder;
import lombok.Data;

import static org.testng.Assert.assertEquals;

public class CreateProjectAPISteps {
    private ProjectAPI projectAPI;

    private Project currentProject;

    @Data @Builder
    public static class Project{
        String key;
        String name;
        String projectTypeKey;
        String projectTemplateKey;
        String lead;
        int permissionScheme;
    }

    public CreateProjectAPISteps(){
       projectAPI = new ProjectAPI();
    }

    @When("I create a project with {string}, {string}, {string}, {string}, {string}, {int}")
    public void createProjectStep(String key, String name, String type, String template, String lead, Integer permissionScheme){
        Response response = projectAPI.postCreateScrumProject(Project.builder()
                .key(key)
                .name(name)
                .projectTypeKey(type)
                .projectTemplateKey(template)
                .lead(lead)
                .permissionScheme(permissionScheme).build());
        response.then().log().all().statusCode(201);

        assertEquals(response.getStatusCode(), 201);
    }

    @And("I get the created project with project key {string}")
    public void getCreatedProject(String projectKey){
        Response response = projectAPI.getProject(projectKey);
        currentProject = Project.builder()
                .key(response.jsonPath().getString("key"))
                .name(response.jsonPath().getString("name"))
                .build();
        response.then().log().all().statusCode(200);
        assertEquals(response.getStatusCode(), 200);
    }

    @Then("The project info should match with {string}, {string}")
    public void checkProjectName(String key, String name){
        assertEquals(currentProject.key, key);
        assertEquals(currentProject.name, name);
    }




}
