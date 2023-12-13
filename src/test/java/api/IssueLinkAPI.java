package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class IssueLinkAPI extends BaseAPI{
    public IssueLinkAPI(){
        requestSpec.basePath("/issueLink");
    }

    public Response postCreateIssueLink(String payload){
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .body(payload)
                .when()
                .post();
    }
}
