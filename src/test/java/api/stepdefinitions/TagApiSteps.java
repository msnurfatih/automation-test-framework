package api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TagApiSteps {

    private Response response;

    private final String baseUrl = "https://dummyapi.io/data/v1";

    private final String appId = "63a804408eb0cb069b57e43a";

    @Given("the DummyAPI request is configured")
    public void theDummyAPIRequestIsConfigured() {
        // Konfigurasi request dilakukan saat request dikirim.
    }

    @When("the user requests the list of tags")
    public void theUserRequestsTheListOfTags() {
        response =
                given()
                        .header("app-id", appId)
                        .when()
                        .get(baseUrl + "/tag");
    }

    @Then("the API response status code should be {int}")
    public void theAPIResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(
                "Unexpected HTTP status code",
                statusCode,
                response.getStatusCode()
        );
    }

    @And("the response should contain a list of tags")
    public void theResponseShouldContainAListOfTags() {
        assertTrue(
                "Response body should not be empty",
                !response.getBody().asString().isEmpty()
        );

        assertTrue(
                "Response should contain the data field",
                response.getBody().asString().contains("\"data\"")
        );
    }
}
