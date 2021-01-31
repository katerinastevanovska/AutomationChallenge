package pages;

import helpers.PageObjectHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by katerina on 1/31/21.
 */
public class LogInPage {

    public LogInPage (WebDriver driver) {
       PageFactory.initElements(driver, this);
    }

    private PageObjectHelper pageObjectHelper = new PageObjectHelper() {
        @Override
        protected WebElement getUniqueElement() {
            return null;
        }
    };


}
