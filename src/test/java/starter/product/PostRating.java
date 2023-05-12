package starter.product;

import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.ProductGetter;

public class PostRating {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set POST api endpoint for assign rating")
    public String setPostApiEndpointRating() {
        int productId = ProductGetter.getProductID();

        return url + "products/" + productId + "/ratings";
    }

    @Step("I send POST request for assign rating")
    public void sendPostHttpRequestRating() {
        String token = GenerateToken.generateToken();

        JSONObject requestBody = new JSONObject();

        requestBody.put("count",4);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setPostApiEndpointRating());
    }
}
