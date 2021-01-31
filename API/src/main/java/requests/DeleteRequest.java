package requests;

import io.restassured.RestAssured;

/**
 * Created by katerina on 1/31/21.
 */
public class DeleteRequest {


    private static String path = "users/{id}";

    public static void delete (String pathParam) {
          RestAssured
                .given()
                .header("Content-Type","application/json")
                .pathParam("id", pathParam)
                .when()
                .delete(path)
                .then()
                .statusCode(204);
    }
}
