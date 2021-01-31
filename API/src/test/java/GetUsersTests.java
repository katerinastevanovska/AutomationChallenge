import core.SetupTest;
import org.testng.annotations.Test;
import requests.GetUsers;
import responses.GetUsersResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

/**
 * Created by katerina on 1/31/21.
 */
public class GetUsersTests extends SetupTest {


    @Test
    public static void verifyResponse() {
        GetUsersResponse resp = GetUsers.getUsers("page", "1");
        for (int i = 1; i <= resp.getTotal_pages(); i++) {
            GetUsersResponse resp1 = GetUsers.getUsers("page", Integer.toString(i));
            assertThat(resp1.getPage(), is(i));
        }
    }

    @Test
    public static void verifyResponseWithPerPage() {
        GetUsersResponse resp = GetUsers.getUsers("page", "1");

        GetUsersResponse resp1 = GetUsers.getUsers("per_page", Integer.toString(resp.getTotal()));
        assertThat(resp1.getTotal_pages(), is(1));
    }

    @Test
    public static void verifyResponseWithMoreThanMaxPage() {
        GetUsersResponse resp = GetUsers.getUsers("page", "1");

        GetUsersResponse resp1 = GetUsers.getUsers("page", Integer.toString(resp.getTotal_pages() + 1));
        assertThat(resp1.getPage(), is(resp.getTotal_pages() + 1));
        assertThat(resp1.getData(), is(empty()));
        }

    @Test
    public static void verifyResponseWithPage200() {
        GetUsersResponse resp1 = GetUsers.getUsers("page", Integer.toString(200));
        assertThat(resp1.getPage(), is(200));
        assertThat(resp1.getData(), is(empty()));
    }
}


