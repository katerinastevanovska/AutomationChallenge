import core.SetupTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AccountPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by katerina on 1/31/21.
 */
public class VerifyPopularCategoryTests extends SetupTest {


    @Test
    public static void verifyPopularCategory () throws Exception {

        AccountPage accountPage = CommonMethods.logIn();
        accountPage.goToHomePage();

        accountPage.verifyVisibilityOfPopularCategory();

        List<WebElement> displayedProducts = accountPage.verifyDisplayedProductsForPopularCategory();
        assertThat(displayedProducts.size(), is(7));
    }
}
