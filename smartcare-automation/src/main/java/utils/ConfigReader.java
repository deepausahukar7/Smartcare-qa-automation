package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties loadProperties() {
        try {
        	FileInputStream fis = new FileInputStream(
        		    System.getProperty("user.dir") +
        		    "/src/test/resources/config.properties");


            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}
