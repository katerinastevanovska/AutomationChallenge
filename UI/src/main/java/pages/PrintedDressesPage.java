package pages;

import helpers.PageObjectHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katerina on 1/31/21.
 */
public class PrintedDressesPage {

    WebDriver driver;

    public PrintedDressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    PageObjectHelper pageObjectHelper = new PageObjectHelper() {
        @Override
        protected WebElement getUniqueElement() {
            return listOfPrintedDresses;
        }
    };

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li")
    WebElement listOfPrintedDresses;

    public List<WebElement> getListedDresses() {
        return driver.findElements(By.xpath(pageObjectHelper.getStringFromxPath(listOfPrintedDresses)));
    }

    public List<String> getTitles () {

        List<WebElement> list = getListedDresses();
        List<String> dresses = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            WebElement single = list.get(i).findElement(By.xpath(
                    pageObjectHelper.getStringFromxPath(list.get(i)) + "[" + (i + 1) + "]/div/div[2]/h5/a"));
            dresses.add(single.getAttribute("Title"));

        }
        return dresses;

    }

}
