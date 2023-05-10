package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.auth.PostRegister;
import starter.utils.Faker;

public class AuthSteps {

    @Steps
    PostRegister postRegister;

    @Given("I set POST api endpoint for register")
    public void setPostApiEndpointRegister() {
        postRegister.setPostApiEndpointRegister();
    }

    @When("I send POST HTTP request for register")
    public void sendPostHttpRequestRegister() {
        postRegister.sendPostHttpRequestRegister();
    }

    @Then("I receive valid data for new user")
    public void validateNewUser() {
        postRegister.validateNewUser();
    }
}
