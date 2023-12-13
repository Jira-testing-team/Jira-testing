package api;

import io.restassured.response.Response;
import stepDef.api.project.CreateProjectAPISteps.Project;

import static io.restassured.RestAssured.given;

public class ProjectAPI extends BaseAPI{
    public ProjectAPI(){
        requestSpec.basePath("/project");
    }


    public Response postCreateScrumProject(Project payload){
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .body(payload)
                .when()
                .post();

    }

    public Response getProject(String projectKey){
        return given(requestSpec)
                .pathParam("projectKey", projectKey)
                .auth().preemptive().basic("admin", "admin")
                .when()
                .get("/{projectKey}");
    }

    public Response addUserToProject(String projectKey, int role, String usernameObject){
        return given(requestSpec)
                .pathParam("projectKey", projectKey)
                .pathParam("role", role)
                .auth().preemptive().basic("admin", "admin")
                .body(usernameObject)
                .when()
                .post("/{projectKey}/role/{role}");
    }



}
