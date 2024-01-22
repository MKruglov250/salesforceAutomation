package utilities;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


@Log4j2
public class LoginUtils {

    private static final JSONParser parser = new JSONParser();
    private static final Object obj;

    static {
        try {
            obj = parser.parse(new FileReader("src/main/resources/credentials.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Get Login from local Credentials storage")
    public static String getLogin() {
        return ((JSONObject) obj).get("login").toString();
    }

    @Step("Get Password from local Credentials storage")
    public static String getPassword(){
        return ((JSONObject) obj).get("password").toString();
    }

    @Step("Get Verification Code from local Credentials storage")
    public static String getVerificationCode(){
        return ((JSONObject) obj).get("verificationCode").toString();
    }

    @Step("Get grant_type from local Credentials storage")
    public static String getGrantType(){
        return ((JSONObject) obj).get("grant_type").toString();
    }

    @Step("Get client_id from local Credentials storage")
    public static String getClientId(){
        return ((JSONObject) obj).get("client_id").toString();
    }

    @Step("Get client_secret from local Credentials storage")
    public static String getClientSecret(){
        return ((JSONObject) obj).get("client_secret").toString();
    }

}
