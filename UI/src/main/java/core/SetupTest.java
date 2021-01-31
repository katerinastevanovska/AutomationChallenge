package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 * Created by katerina on 1/31/21.
 */
public class SetupTest {

    private static String url;
    private static ReadProperties envProps = new ReadProperties("/environment.properties");
    protected static WebDriver driver;
    protected static ReadProperties testProperties = new ReadProperties("/test.properties");



    public SetupTest () {

    }

    @BeforeTest
    public static void setupEnv ()throws Exception {

        driver = createDriver();
        testProperties.setEmail();
        url = envProps.getProperty("URL");

        if(url != null) {
            driver.get(url);
        } else throw new RuntimeException("No url provided");

    }

    @AfterTest(alwaysRun = true)
    public static void tearDown () {
        driver.quit();
    }

    private static WebDriver createDriver () {

        if(envProps.getProperty("Browser").equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        } else {
            //TODO
        }

        return driver;

    }

    public static void main (String[] args) {
        System.out.println(LocalDate.now());
    }
}
