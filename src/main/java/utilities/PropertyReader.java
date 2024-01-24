package utilities;

import io.qameta.allure.Step;

import java.io.*;
import java.util.Properties;

public abstract class PropertyReader {
    private static Properties properties;

    private static void readProperties() throws FileNotFoundException {
        properties = new Properties();
        File initialFile = new File("src/main/resources/config.properties");
        InputStream inputStream = new FileInputStream(initialFile);
        try {
            properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) throws FileNotFoundException {
        if (properties == null) {
            readProperties();
        }
        return properties.getProperty(key);
    }

    public static String getSecureProperty(String propertyName) throws FileNotFoundException {
        String systemProperty = System.getProperty(propertyName);
        if (systemProperty != null) {
            return systemProperty;
        }
        else return getProperty(propertyName);
    }


    @Step("Get browser to perform test")
    public static String getBrowserProperty( ) throws FileNotFoundException {
        return getProperty("Browser");
    }

    @Step("Get timeout for locating elements")
    public static int getTimeoutProperty( ) throws FileNotFoundException {
        return Integer.parseInt(getProperty("Timeout"));
    }

    public static String getLogin() throws FileNotFoundException {
        return getSecureProperty("login");
    }

    public static String getPassword() throws FileNotFoundException {
        return getSecureProperty("password");
    }

    public static String getVerificationCode() throws FileNotFoundException {
        return getSecureProperty("verificationCode");
    }

    public static String getGrantType() throws FileNotFoundException {
        return getSecureProperty("grant_type");
    }

    public static String getClientId() throws FileNotFoundException {
        return getSecureProperty("client_id");
    }

    public static String getClientSecret() throws FileNotFoundException {
        return getSecureProperty("client_secret");
    }

    public static String getApiUrl() throws FileNotFoundException {
        return getSecureProperty("ApiUrl");
    }

    public static String getLoginUrl() throws FileNotFoundException {
        return getSecureProperty("LoginUrl");
    }



}
