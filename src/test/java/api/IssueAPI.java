package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class IssueAPI extends BaseAPI{
    public IssueAPI(){
        requestSpec.basePath("/issue");
    }

    public Response postCreateEpic(String epicObject){
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .body(epicObject)
                .when()
                .post();
    }
    public Response postCreateIssue(String issueObject){
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .body(issueObject)
                .when()
                .post();
    }

    public Response putAssignIssue(String issueKey, String body){
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .pathParam("issueKey", issueKey)
                .body(body)
                .when()
                .put("/{issueKey}/assignee");
    }

    public Response postCreateComment(String issueKey, String body){
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .pathParam("issueKey", issueKey)
                .body(body)
                .when()
                .post("/{issueKey}/comment");

    }

    public Response putEditComment(String issueKey, String commentId, String body){
        return given(requestSpec)
                .auth().preemptive().basic("admin", "admin")
                .pathParam("issueKey", issueKey)
                .pathParam("commentId", commentId)
                .body(body)
                .when()
                .put("/{issueKey}/comment/{commentId}");

    }


}
