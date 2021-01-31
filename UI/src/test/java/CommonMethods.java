import core.SetupTest;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AccountPage;
import pages.CreateAnAccPage;
import pages.HomePage;
import pages.SignInPage;

/**
 * Created by katerina on 1/31/21.
 */
public class CommonMethods extends SetupTest {

    public static AccountPage logIn () {

        HomePage homePage = new HomePage(driver);
        homePage.signIn();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress(testProperties.getProperty("email"));
        signInPage.createAccount();

        CreateAnAccPage createAnAccPage = new CreateAnAccPage(driver);
        createAnAccPage.populateAllFields(testProperties);
        createAnAccPage.createAccount();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.verifySignOutVisability();

        return accountPage;
    }
}
