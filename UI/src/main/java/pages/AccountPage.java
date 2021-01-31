package pages;

import helpers.PageObjectHelper;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.smartcardio.CommandAPDU;
import java.util.List;

/**
 * Created by katerina on 1/31/21.
 */
public class AccountPage {

    WebDriver driver;

    public AccountPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private PageObjectHelper pageObjectHelper = new PageObjectHelper() {
        @Override
        protected WebElement getUniqueElement() {
            return signOut;
        }
    };

    @FindBy (xpath = "//a[contains(@title, \"Log me out\")]")
    public static WebElement signOut;

    @FindBy(css = "input[id=\"search_query_top\"]")
    public static WebElement searchBar;

    @FindBy (xpath = "//*[@id=\"searchbox\"]/button")
    public static WebElement searchButton;

    @FindBy (xpath = "//*[@id=\"header_logo\"]/a")
    public static WebElement accHomePage;

    @FindBy (xpath = "//*[@id=\"homefeatured\"]/li")
    public static WebElement displayedProductsPopular;

    @FindBy (xpath = "//*[@id=\"blockbestsellers\"]/li")
    public static WebElement displayedProductsBestSellers;

    @FindBy (xpath = "//*[@id=\"home-page-tabs\"]/li[2]/a")
    public static WebElement bestSellers;

    @FindBy (xpath = "//*[@id=\"home-page-tabs\"]/li[1]/a")
    public static WebElement popular;

    public void verifySignOutVisability () {

        pageObjectHelper.isElementVisible(signOut);

    }

    public void searchText (String text) {
        pageObjectHelper.isPageLoaded();
        searchBar.sendKeys(text);
        searchButton.click();
    }

    public void goToHomePage () {
        pageObjectHelper.isPageLoaded();
        accHomePage.click();
    }

    public List<WebElement> verifyDisplayedProductsForPopularCategory() {
        pageObjectHelper.isPageLoaded();
        return driver.findElements(By.xpath(pageObjectHelper.getStringFromxPath(displayedProductsPopular)));
    }
    public List<WebElement> verifyDisplayedProductsForBestSellersCategory() {
        pageObjectHelper.isPageLoaded();
        return driver.findElements(By.xpath(pageObjectHelper.getStringFromxPath(displayedProductsBestSellers)));
    }


    public void navigateToBestSellersCategory () {
        pageObjectHelper.isPageLoaded();
        bestSellers.click();
    }

    public void verifyVisibilityOfPopularCategory () {
        pageObjectHelper.isPageLoaded();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(popular));
    }
}


