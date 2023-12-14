package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GroupAPI extends BaseAPI {
    public GroupAPI() {requestSpec.basePath("/group");}

    public Response createGroup(String username, String password, String groupName) {
        Map<String, String> name = new HashMap<>();
        name.put("name", groupName);
        Response response =  given(requestSpec)
                .auth().preemptive().basic(username, password)
                .body(name)
                .when()
                .post();
        response.then()
                .spec(responseSpec);
        return response;
    }

    public Response addUserToGroup(String username, String password, String user, String groupName) {
        Map<String, String> name = new HashMap<>();
        name.put("name", user);
        Response response =  given(requestSpec)
                .auth().preemptive().basic(username, password)
                .queryParam("groupname", groupName)
                .body(name)
                .when()
                .post("/user");
        response.then()
                .spec(responseSpec);
        return response;
    }

    public Response getUsersFromGroup(String username, String password, String groupName) {
        Response response = given(requestSpec)
                .auth().preemptive().basic(username, password)
                .contentType(ContentType.JSON)
                .queryParam("groupname", groupName)
                .when()
                .get("/member");
        response.then()
                .spec(responseSpec);
        return response;
    }
}