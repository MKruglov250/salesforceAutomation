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
    AccountModel editedAccount = AccountModelBuilder.getEditedAccount();
    AccountModel emptyAccount = AccountModelBuilder.getEmptyAccount();
    static String newAccountId;

    public AccountsApiTest() throws IOException, ParseException {
    }

    @Test(description = "Create New Account", groups = "Smoke")
    public void createAccountTest(){
        log.info("Test: create new account");
        Response response = accountsApi.createAccount(account);
        account.setId(response.body().jsonPath().getString("id"));
        newAccountId = account.getId();
        Assert.assertEquals(response.body().jsonPath().getString("success"),"true");
    }

    @Test(description = "Create Empty Account", groups = "Regression")
    public void createEmptyAccountTest(){
        log.info("Test: create empty account");
        Response response = accountsApi.createEmptyAccount(emptyAccount);
        Assert.assertEquals(response.body().jsonPath().getString("message"),
                "[Required fields are missing: [Name]]");
        Assert.assertEquals(response.body().jsonPath().getString("errorCode"),
                "[REQUIRED_FIELD_MISSING]");
    }


    @Test(description = "Read Existing Account", groups = "Smoke")
    public void readAccountTest(){
        log.info("Test: read existing account");
        Response response = accountsApi.getAccount(newAccountId);
        Assert.assertEquals(response.body().jsonPath().getString("Name"),
                account.getAccountName());
    }

    @Test(description = "Read Existing Account: full comparison", groups = "Smoke")
    public void readAccountFullComparison(){
        log.info("Test: read existing account - full data fields comparison");
        Response response = accountsApi.getAccount(newAccountId);
        Assert.assertEquals(gson.fromJson(response.body().asString(), AccountModel.class),
                account);
    }

    @Test(description = "Update Existing Account", groups = "Regression", priority = 1)
    public void updateAccountTest(){
        log.info("Test: update existing account");
        accountsApi.updateAccount(newAccountId,editedAccount);
        Response response = accountsApi.getAccount(newAccountId);
        Assert.assertEquals(response.body().jsonPath().getString("Name"),
                editedAccount.getAccountName());
    }

    @Test(description = "Get list of accounts", groups = "Smoke", priority = 2)
    public void getAccountsListTest(){
        log.info("Test: get list of existing accounts");
        Response response = accountsApi.getAccountsList();
        String recentAccount = gson.toJson(response.body().jsonPath()
                .getList("recentItems").get(0));
        Assert.assertTrue(recentAccount.contains("Edited Account"));
    }

    @Test(description = "Delete Existing Account", groups = "Regression", priority = 3)
    public void deleteAccountTest(){
        log.info("Test: delete existing account");
        accountsApi.deleteAccount(newAccountId);
        Response response = accountsApi.getDeletedAccount(newAccountId);
        Assert.assertEquals(response.statusCode(),
                404);
    }
}
