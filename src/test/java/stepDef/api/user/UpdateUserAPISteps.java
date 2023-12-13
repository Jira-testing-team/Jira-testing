package stepDef.api.user;

import api.UserAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import static org.testng.Assert.*;

public class UpdateUserAPISteps {
    private UserAPI userAPI;
    private Response response;

    public UpdateUserAPISteps() {
        userAPI = new UserAPI();
    }

    @Given("I sent a put request for changing the active status of a user with {string} to false")
    public void i_sent_a_put_request_for_changing_the_active_status_of_a_user_with_to_false(String username) {
        HashMap<String, String> map = new HashMap<>();
        map.put("active", "false");
        userAPI.updateUser(username, map);
    }
    @When("I get the information of this user with {string}")
    public void i_get_the_information_of_this_user_with(String username) {
        response = userAPI.getUser(username);
    }
    @Then("I should see the value of active status is false")
    public void i_should_see_the_value_of_active_status_is_false() {
        String actualStatus = response.jsonPath().getString("active");
        assertEquals(actualStatus, "false");
    }
}
