import core.SetupTest;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import requests.DeleteRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by katerina on 1/31/21.
 */
public class DeleteTests extends SetupTest {

    @Test
    public static void deleteUser () {

        DeleteRequest.delete(testProps.getProperty("userID"));

    }
}
