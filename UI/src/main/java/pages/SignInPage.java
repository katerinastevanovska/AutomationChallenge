package pages;

import helpers.PageObjectHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by katerina on 1/31/21.
 */
public class SignInPage {


    public SignInPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    private PageObjectHelper pageObjectHelper = new PageObjectHelper() {
        @Override
        protected WebElement getUniqueElement() {
            return createAccount;
        }
    };

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    public static WebElement createAccount;

    @FindBy (xpath = "//*[@id=\"email_create\"]")
    public static WebElement emailAddress;


    public void createAccount () {
        pageObjectHelper.isPageLoaded();
        createAccount.click();
    }

    public void enterEmailAddress (String address) {

        //if the Create account key is visible we expect all elements of the page to be visible. That is the reason why we check if the page is loaded according to one element.
        pageObjectHelper.isPageLoaded();
        emailAddress.sendKeys(address);
    }
}
