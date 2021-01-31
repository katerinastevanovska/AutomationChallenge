package requests;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import responses.SuccessfullRegisterResponse;
import responses.UnsuccessfulRegisterResponse;

/**
 * Created by katerina on 1/31/21.
 */
public class RegisterRequest {

    private String REGISTER_PATH = "register";


    private String email;
    private String password;

    public RegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;

    }

    private JsonObject getBodyWithEmail() {

        JsonObject body = new JsonObject();
        body.addProperty("email", email);

        return body;
    }

    private JsonObject getBody() {

        JsonObject body = new JsonObject();
        body.addProperty("email", email);
        body.addProperty("password", password);
        return body;
    }

    private JsonObject getBodyWithPassOnly() {

        JsonObject body = new JsonObject();

        body.addProperty("password", password);
        return body;
    }

    public UnsuccessfulRegisterResponse registerwithEmail() {

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(getBodyWithEmail().toString())
                .when()
                .post(REGISTER_PATH)
                .then()
                .statusCode(400)
                .extract().as(UnsuccessfulRegisterResponse.class);
    }

    public UnsuccessfulRegisterResponse registerFull() {

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(getBody().toString())
                .when()
                .post(REGISTER_PATH)
                .then()
                .statusCode(400)
                .extract().as(UnsuccessfulRegisterResponse.class);
    }

    public UnsuccessfulRegisterResponse registerWithPassOnly() {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(getBodyWithPassOnly().toString())
                .when()
                .post(REGISTER_PATH)
                .then()
                .statusCode(400)
                .extract().as(UnsuccessfulRegisterResponse.class);
    }

    public SuccessfullRegisterResponse successfullRegister() {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(getBody().toString())
                .when()
                .post(REGISTER_PATH)
                .then()
                .statusCode(200)
                .extract().as(SuccessfullRegisterResponse.class);
    }
}
