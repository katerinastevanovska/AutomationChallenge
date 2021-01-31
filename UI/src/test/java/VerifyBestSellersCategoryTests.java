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
public class VerifyBestSellersCategoryTests extends SetupTest {


    @Test
    public static void verifyPopularCategory (){

        AccountPage accountPage = CommonMethods.logIn();
        accountPage.goToHomePage();
        accountPage.navigateToBestSellersCategory();

        List<WebElement> displayedProducts = accountPage.verifyDisplayedProductsForBestSellersCategory();
        assertThat(displayedProducts.size(), is(7));
    }
}
