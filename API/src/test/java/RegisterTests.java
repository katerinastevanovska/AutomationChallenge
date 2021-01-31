import core.SetupTest;
import org.testng.annotations.Test;
import requests.RegisterRequest;
import responses.SuccessfullRegisterResponse;
import responses.UnsuccessfulRegisterResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by katerina on 1/31/21.
 */
public class RegisterTests extends SetupTest{


    @Test
    public static void unsuccessfulRegister () {

        RegisterRequest registerRequest = new RegisterRequest(testProps.getProperty("email"), testProps.getProperty("password"));
        UnsuccessfulRegisterResponse resp = registerRequest.registerwithEmail();

        assertThat(resp.getError(), is("Missing password"));
    }

    @Test
    public static void unsuccessfulRegisterWithPasswordOnly () {

        RegisterRequest registerRequest = new RegisterRequest(testProps.getProperty("email"), testProps.getProperty("password"));
        UnsuccessfulRegisterResponse resp = registerRequest.registerWithPassOnly();

        assertThat(resp.getError(), is("Missing email or username"));
    }

    @Test
    public static void unsuccessfulRegisterWithFullBody () {

        RegisterRequest registerRequest = new RegisterRequest(testProps.getProperty("email"), testProps.getProperty("password"));
        UnsuccessfulRegisterResponse resp = registerRequest.registerFull();

        assertThat(resp.getError(), is("Note: Only defined users succeed registration"));
    }

    @Test
    public static void successfulRegister () {

        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", "pistol");
        SuccessfullRegisterResponse resp = registerRequest.successfullRegister();
    }

}
