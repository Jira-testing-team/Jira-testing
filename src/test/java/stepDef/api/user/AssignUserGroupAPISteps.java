package stepDef.api.user;

import api.UserAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static org.testng.Assert.*;

public class AssignUserGroupAPISteps {
    private UserAPI userAPI;
    private Response response;

    public AssignUserGroupAPISteps() {
        userAPI = new UserAPI();
    }


    @Given("I send a post request to http:\\/\\/localhost:8080\\/rest\\/api\\/2\\/group\\/user to assign {string} to {string}")
    public void i_send_a_post_request_to_http_localhost_rest_api_group_user_to_assign_a_user_to_a_group(String username, String groupName) {
        response = userAPI.assignGroup(groupName, username);
    }
    @Then("I should get a status code of 201")
    public void i_should_get_a_status_code_of() {
        assertEquals(response.getStatusCode(), 201);
    }

}
