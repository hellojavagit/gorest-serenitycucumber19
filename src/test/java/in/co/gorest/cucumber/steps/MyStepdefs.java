package in.co.gorest.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.co.gorest.usersinfo.UsersSteps;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {
    static String name = "Tenali Ramakrishnaveni"+ TestUtils.getRandomValue();
    static String gender = "female";
    static String email = "tenalii.ramakrishna1@gmail.com"+TestUtils.getRandomValue();
    static String status = "active";
    static int id;

    static ValidatableResponse  response;

    @Steps
    UsersSteps usersSteps;


    @When("^I use get method to send request to the application$")
    public void iUseGetMethodToSendRequestToTheApplication() {
        response = usersSteps.getListOfUsers();
    }

    @Then("^I must get back a valid status code (\\d+)$")
    public void iMustGetBackAValidStatusCode(int arg0) {
        response.statusCode(200);
    }

    @When("^I use post method and send payload to create a new user$")
    public void iUsePostMethodAndSendPayloadToCreateANewUser() {
        response = usersSteps.createUser(name,gender,email,status);

        id = response.log().all().extract().path("id");
        System.out.println(id);

    }

    @Then("^I must get back a valid status code (\\d+) as response$")
    public void iMustGetBackAValidStatusCodeAsResponse(int arg0) {
        response.log().all().statusCode(201);
    }

    @When("^I send a patch request using payload$")
    public void iSendAPatchRequestUsingPayload() {
        name = name +"_updated";
        ValidatableResponse response = usersSteps.createUser(name,gender,email,status);
        response.log().all().statusCode(200);
    }

    @Then("^I should get a valid status code (\\d+)  as response$")
    public void iShouldGetAValidStatusCodeAsResponse(int arg0) {
        response.statusCode(200);
    }

    @When("^I send a delete request to perform on the application$")
    public void iSendADeleteRequestToPerformOnTheApplication() {
        usersSteps.deleteUserById(id).statusCode(204);
    }
}
