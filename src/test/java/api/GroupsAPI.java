package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GroupsAPI extends BaseAPI {
    public GroupsAPI() {requestSpec.basePath("/groups/picker");}

    public Response getGroups(String username, String password) {
        Response response = given(requestSpec)
                .auth().preemptive().basic(username, password)
                .when()
                .get();
        response.then()
                .spec(responseSpec);
        return response;
    }
}