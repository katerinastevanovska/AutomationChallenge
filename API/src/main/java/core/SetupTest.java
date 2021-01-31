package core;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

/**
 * Created by katerina on 1/31/21.
 */
public class SetupTest {

    protected static  ReadProperties testProps = new ReadProperties("/test.properties");

    @BeforeTest
    public static void setupTest () {
        RestAssured.baseURI = new ReadProperties("/environment.properties").getProperty("URL");
    }

}
