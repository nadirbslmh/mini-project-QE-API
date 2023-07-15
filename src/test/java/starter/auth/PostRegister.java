package starter.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.FileUtil;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class PostRegister {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set POST api endpoint for register")
    public String setPostApiEndpointRegister() {
        return url + "auth/register";
    }

    @Step("I send POST HTTP request for register")
    public void sendPostHttpRequestRegister() {
        JSONObject requestBody = FileUtil.getUser();

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setPostApiEndpointRegister());
    }

    @Step("I receive valid data for new user")
    public void validateNewUser() {
        restAssuredThat(response -> response.body("'data'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Fullname'", notNullValue()));
    }
}
