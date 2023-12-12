package api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    protected RequestSpecification requestSpec = given()
            .baseUri("http://localhost:8080/rest/api/2")
            .contentType(ContentType.JSON);


    protected ResponseSpecification responseSpec = given().then()
            .response()
            .time(Matchers.lessThan(10L), TimeUnit.SECONDS);
}
