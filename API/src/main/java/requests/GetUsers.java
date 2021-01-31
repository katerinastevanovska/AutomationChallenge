package requests;

import io.restassured.RestAssured;
import responses.GetUsersResponse;

/**
 * Created by katerina on 1/31/21.
 */
public class GetUsers {

    public static String path = "users";

    public static GetUsersResponse getUsers (String queryParam, String queryValue) {
       return RestAssured
                .given()
                .queryParam(queryParam, queryValue)
                .when()
                .get(path)
                .then()
                .extract().as(GetUsersResponse.class);
    }
}
