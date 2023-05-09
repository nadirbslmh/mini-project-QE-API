package starter.utils;

import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

public class GenerateToken {
    public static String generateToken() {
        JSONObject loginRequestBody = new JSONObject();

        loginRequestBody.put("email","ganti@mail.com");
        loginRequestBody.put("password","123123");

        ResponseBody loginResponse = SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(loginRequestBody.toString())
                .post("https://altashop-api.fly.dev/api/auth/login")
                .body();

        JSONObject loginResponseBody = new JSONObject(loginResponse.asString());

        return loginResponseBody.getString("data");
    }
}
