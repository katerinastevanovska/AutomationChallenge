package pages;

import core.ReadProperties;
import helpers.PageObjectHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by katerina on 1/31/21.
 */
public class CreateAnAccPage {

    private ReadProperties testProps = new ReadProperties("/test.properties");


    public CreateAnAccPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private PageObjectHelper pageObjectHelper = new PageObjectHelper() {
        @Override
        protected WebElement getUniqueElement() {
            return firstName;
        }
    };

    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    WebElement maleGender;

    @FindBy (xpath = "//*[@id=\"id_gender2\"]")
    WebElement femaleGender;

    @FindBy (xpath = "//*[@id=\"customer_firstname\"]")
    WebElement firstName;

    @FindBy (xpath = "//*[@id=\"customer_lastname\"]")
    WebElement lastName;

    @FindBy (css = "input[id=\"passwd\"]")
    WebElement password;

    @FindBy (css = "select[id=\"days\"]")
    WebElement birthDate;

    @FindBy (css = "select[id=\"months\"]")
    WebElement birthMonths;

    @FindBy (css = "select[id=\"years\"]")
    WebElement birthYears;

    @FindBy (css = "input[id=\"address1\"]")
    WebElement address;

    @FindBy (css = "input[id=\"city\"]")
    WebElement city;

    @FindBy (css = "select[id=\"id_state\"]")
    WebElement state;

    @FindBy (css = "input[id=\"postcode\"]")
    WebElement postCode;

    @FindBy (css = "input[id=\"phone_mobile\"]")
    WebElement phoneMobile;

    @FindBy (css = "button[id=\"submitAccount\"]")
    WebElement submitAcc;

    public void setMaleGender (boolean isMale) {

        pageObjectHelper.isPageLoaded();

        if(isMale) {
            maleGender.click();
        } else {
            femaleGender.click();
        }

    }

    public void setFirstName (String name) {

        pageObjectHelper.isPageLoaded();
        firstName.sendKeys(name);
    }


    public void setState (String stateStr) {
        pageObjectHelper.isPageLoaded();
        state.sendKeys(stateStr);
    }

    public void setLastName (String surname) {
        pageObjectHelper.isPageLoaded();
        lastName.sendKeys(surname);
    }

    public void setPassword () {
        pageObjectHelper.isPageLoaded();
        password.sendKeys(testProps.getProperty("password"));
    }

    public void setBirthDate (LocalDate date) {

        pageObjectHelper.isPageLoaded();
        birthDate.sendKeys(Integer.toString(date.getDayOfMonth()));
        birthMonths.sendKeys(date.getMonth().toString().toLowerCase());
        birthYears.sendKeys(Integer.toString(date.getYear()));
    }


    public void setAddress (String addressStr) {

        pageObjectHelper.isPageLoaded();
        address.sendKeys(addressStr);
    }

    public void setCity (String cityStr) {
        pageObjectHelper.isPageLoaded();
        city.sendKeys(cityStr);
    }

    public void setPostCode(String code) {
        pageObjectHelper.isPageLoaded();
        postCode.sendKeys(code);
    }

    public void setPhoneMobile(String phoneMobileStr) {

        pageObjectHelper.isPageLoaded();
        phoneMobile.sendKeys(phoneMobileStr);
    }

    public void createAccount ()  {
        pageObjectHelper.isPageLoaded();
        submitAcc.click();
    }

    public void populateAllFields (ReadProperties testProps) {

        setAddress(testProps.getProperty("address"));
        setBirthDate(LocalDate.parse(testProps.getProperty("dateOfBirth")));
        setCity(testProps.getProperty("city"));
        setFirstName(testProps.getProperty("name"));
        setLastName(testProps.getProperty("surname"));
        setMaleGender(new Boolean(testProps.getProperty("isMale")));
        setPassword();
        setPhoneMobile(testProps.getProperty("mobileNumber"));
        setPostCode(testProps.getProperty("zipCode"));
        setState(testProps.getProperty("state"));

    }


}
