package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SearchAPI extends BaseAPI{
    public SearchAPI(){
        requestSpec.basePath("/search");
    }

    public Response getAllStoriesByProject(String projectKey){
        //project = projectKey, type = story
        String jql = "project = "+projectKey+" and type = story";
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .queryParam("jql", jql)
                .when()
                .get();
    }
    public Response getAllStoriesByUsername(String username){
        //project = projectKey, type = story
        String jql = "assignee = "+username;
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .queryParam("jql", jql)
                .when()
                .get();
    }

}
