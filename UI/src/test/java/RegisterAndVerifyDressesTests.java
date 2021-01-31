import com.google.common.io.ByteSource;
import com.google.common.io.CharStreams;
import core.SetupTest;
import org.apache.commons.io.Charsets;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.*;
import sun.misc.IOUtils;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by katerina on 1/31/21.
 */

public class RegisterAndVerifyDressesTests extends SetupTest {

    @Test
    public static void registerAndVerifyDresses () throws Exception {

       AccountPage accountPage =  CommonMethods.logIn();
       accountPage.searchText("Printed Dresses");

        PrintedDressesPage printedDressesPage = new PrintedDressesPage(driver);
        List<String> actualDresses = printedDressesPage.getTitles();

        PrintWriter writer;
        try{
             writer = new PrintWriter("titles.txt", "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException();
        }
        actualDresses.stream().forEach(title-> writer.println(title));
        writer.close();
    }

}
