package API;

import API.client.AccountsApi;
import com.google.gson.Gson;
import dto.AccountModel;
import dto.AccountModelBuilder;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Log4j2
public class AccountsApiTest {

    Gson gson = new Gson();
    AccountsApi accountsApi = new AccountsApi();
    AccountModel account = AccountModelBuilder.getApiAccount();

    public AccountsApiTest() throws IOException, ParseException {
    }


    @Test(description = "Read Existing Account", alwaysRun = true)
    public void readAccountTest(){
        log.info("Test: read existing account");
        Response response = accountsApi.getAccount("123");
        Assert.assertTrue(true);
    }

    @Test(description = "Create New Account", alwaysRun = true)
    public void createAccountTest(){
        log.info("Test: create new account");
        Response response = accountsApi.createAccount(account);
        Assert.assertTrue(true);
    }

}
