package API;

import API.client.AccountsApi;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Log4j2
public class AccountsApiTest {

    AccountsApi accountsApi = new AccountsApi();

    public AccountsApiTest() throws IOException, ParseException {
    }


    @Test(description = "Read Existing Account", alwaysRun = true)
    public void readAccount(){
        log.info("Reading existing account");
        Response response = accountsApi.getAccount("123");
        Assert.assertTrue(true);
    }

}
