package utilities;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


@Log4j2
public class AccountUtils {

    static JSONParser parser = new JSONParser();
    static Object obj;

    static {
        try {
            obj = parser.parse(new FileReader("src/main/resources/testAccount.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static JSONObject jsonObj = (JSONObject) obj;

    @Step("Get {string} attribute from Account JSON")
    public static String getAttribute(String attribute){
        return jsonObj.get(attribute).toString();
    }

}
