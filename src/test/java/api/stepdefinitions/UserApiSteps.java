
package api.stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class UserApiSteps {

    private Response response;

    private final String baseUrl = "https://dummyapi.io/data/v1";
    private final String appId = "63a804408eb0cb069b57e43a";

    @When("the user requests a user by ID {string}")
    public void theUserRequestsAUserByID(String userId) {
        response =
                given()
                        .header("app-id", appId)
                        .when()
                        .get(baseUrl + "/user/" + userId);
    }

    @And("the user response should contain an ID")
    public void theUserResponseShouldContainAnID() {
        String id = response.jsonPath().getString("id");

        assertNotNull("User ID should not be null", id);
        assertFalse("User ID should not be empty", id.isEmpty());
    }

    @Then("the user API response status code should be {int}")
    public void theUserAPIResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(
                "Unexpected HTTP status code",
                statusCode,
                response.getStatusCode()
        );
    }

    @When("the user creates a new user with name {string}")
    public void theUserCreatesANewUser(String name) {
        String requestBody = "{"
                + "\"firstName\":\"" + name + "\","
                + "\"lastName\":\"Automation\","
                + "\"email\":\"qa." + System.currentTimeMillis()
                + "@example.com\""
                + "}";

        response =
                given()
                        .header("app-id", appId)
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post(baseUrl + "/user/create");
    }

    @Then("the user creation response status code should be {int}")
    public void theUserCreationResponseStatusCodeShouldBe(int statusCode) {
        System.out.println("Create User Status Code: " + response.getStatusCode());
        System.out.println("Create User Response Body: " + response.getBody().asString());
        assertEquals(
                "Unexpected user creation status code",
                statusCode,
                response.getStatusCode()
        );
    }

    @And("the created user response should contain an ID")
    public void theCreatedUserResponseShouldContainAnID() {
        String id = response.jsonPath().getString("id");

        assertNotNull("Created user ID should not be null", id);
        assertFalse("Created user ID should not be empty", id.isEmpty());
    }

    @When("the user updates a user by ID {string} with name {string}")
    public void theUserUpdatesAUserByID(String userId, String name) {
        String requestBody = "{"
                + "\"firstName\":\"" + name + "\""
                + "}";

        response =
                given()
                        .header("app-id", appId)
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .put(baseUrl + "/user/" + userId);
    }

    @Then("the user update response status code should be {int}")
    public void theUserUpdateResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(
                "Unexpected user update status code",
                statusCode,
                response.getStatusCode()
        );
    }
}
