package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Created by katerina on 1/31/21.
 */
public class DelayedRequest {

    public static Response delayedRequest (int seconds) {

       return RestAssured.given()
                .queryParam("delay", seconds)
                .when()
                .get(GetUsers.path);
    }
}
