package stepDef.api.user;

import api.UserAPI;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class CreateUserAPISteps {
    UserAPI userAPI;
    Response response;

    public CreateUserAPISteps() {
        userAPI = new UserAPI();
    }

    @Given("I send the request for creating user with user information as {string}, {string}, {string}, {string}")
    public void I_send_the_request_for_creating_user_with_user_information_as(String name, String password, String emailAddress, String displayName) {
        response = userAPI.createUser(name, password, emailAddress, displayName);
    }

    @Then("I should get the status code of 201 indicating I sucessfully created the user")
    public void I_should_get_the_status_code_of_201_indicating_I_sucessfully_created_the_user() {
        assertEquals(response.getStatusCode(), 201);
    }
}
