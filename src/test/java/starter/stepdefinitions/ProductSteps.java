package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.product.Get;
import starter.product.Post;

public class ProductSteps {
    @Steps
    Get get;

    @Steps
    Post post;

    @Given("I set GET api endpoint")
    public void setGetApiEndpoints() {
        get.setApiEndpoint();
    }

    @When("I send GET HTTP request")
    public void sendGetHttpRequest() {
        get.sendGetHttpRequest();
    }

    @Then("I receive valid HTTP response code 200")
    public void receiveValidHttpResponses() {
        get.validateHttpResponseCode200();
    }

    @Given("I set POST api endpoint")
    public void setPostApiEndpoint() {
        post.setPostApiEndpoint();
    }

    @When("I send POST HTTP request")
    public void sendPostHttpRequest() {
        post.sendPostHttpRequest();
    }

    @And("I receive valid data for new product")
    public void validateDataNewProduct() {
        post.validateDataNewProduct();
    }
}
