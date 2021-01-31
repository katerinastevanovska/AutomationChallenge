import core.SetupTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.DelayedRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Created by katerina on 1/31/21.
 */
public class DelayedResponseTests extends SetupTest{

    @Test
    public static void delayRequest() {

        int delay = new Integer(testProps.getProperty("delay"));
        Response resp = DelayedRequest.delayedRequest(delay);
        Assert.assertTrue(resp.getTime() > delay * 1000);

    }
}
