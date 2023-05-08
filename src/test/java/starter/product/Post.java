package starter.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set POST api endpoint")
    public String setPostApiEndpoint() {
        return url + "products";
    }

    @Step("I send POST HTTP request")
    public void sendPostHttpRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Sony PS5 Slim");
        requestBody.put("description","play has no limits");
        requestBody.put("price",299);
        requestBody.put("categories", new int[1]);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setPostApiEndpoint());
    }

    @Step("I receive valid data for new product")
    public void validateDataNewProduct() {
        restAssuredThat(response -> response.body("'data'.'Name'", equalTo("Sony PS5 Slim")));
    }
}
