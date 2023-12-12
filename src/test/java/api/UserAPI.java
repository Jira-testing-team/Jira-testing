package api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import java.util.HashMap;

public class UserAPI extends BaseAPI {
    public UserAPI() {
        requestSpec
                .auth().preemptive().basic("leozhu333", "password123");
    }
    public Response createUser(String name, String password, String emailAddress, String displayName) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("password", password);
        map.put("emailAddress", emailAddress);
        map.put("displayName", displayName);
        Response response = given(requestSpec)
                .body(map)
                .when()
                .post("/user");
        response.then()
                .spec(responseSpec);
        return response;
    }

    public Response getUser(String username) {
        Response response = given(requestSpec)
                .queryParam("username", username)
                .when()
                .get("/user");
        response.then()
                .spec(responseSpec);
        return response;
    }

    public Response updateUser(String username, HashMap<String, String> map) {
        Response response = given(requestSpec)
                .queryParam("username", username)
                .body(map)
                .when()
                .put("/user");
        response.then()
                .spec(responseSpec);
        return response;
    }

    public Response assignGroup(String groupName, String username) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", username);
        Response response = given(requestSpec)
                .queryParam("groupname", groupName)
                .body(map)
                .when()
                .post("/group/user");
        response.then()
                .spec(responseSpec);
        return response;

    }
}
