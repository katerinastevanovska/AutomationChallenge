package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by katerina on 1/31/21.
 */
public class ReadProperties {

    private Properties properties;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ReadProperties(String fileName){

        InputStream inputStream = getClass().getResourceAsStream(fileName);

        this.properties = new Properties();
        if (inputStream != null) {
            try {
                this.properties.load(inputStream);
            } catch (IOException exception) {
                logger.debug("Error trying to load the file content: " + fileName);
            }
        } else {
            logger.debug("Error reading " + fileName);
        }
    }

    public String getProperty (String propertyName) {
        return this.properties.getProperty(propertyName);
    }

    public void setEmail () {

        String unique = Long.toString(System.currentTimeMillis());

        StringBuilder email = new StringBuilder();
        email.append(unique);
        email.append(this.properties.getProperty("email"));

        this.properties.setProperty("email", email.toString());
    }
}
