package helpers;

import core.SetupTest;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by katerina on 1/31/21.
 */
public abstract class PageObjectHelper extends SetupTest {

    public void isPageLoaded () {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(getUniqueElement()));
    }

    protected  boolean isElementEnabled(WebElement element) {
        String cssClass = element.getAttribute("class");

        return !(cssClass != null && cssClass.contains("disabled")) && element.isEnabled();
    }

    public void isElementVisible (WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getStringFromxPath (WebElement elem) {
        String xpath = StringUtils.substring(elem.toString(), StringUtils.indexOf( elem.toString(),"xpath:") + new String("xpath:").length()).trim();
        return xpath.substring(0, xpath.length()-1);

    }
    protected abstract WebElement getUniqueElement();
}
