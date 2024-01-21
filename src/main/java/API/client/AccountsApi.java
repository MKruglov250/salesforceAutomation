package API.client;

import API.base.BaseApi;
import com.google.gson.Gson;
import dto.Account;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import java.io.IOException;

@Log4j2
public class AccountsApi extends BaseApi {

    static String accountEndpoint = "services/data/v59.0/sobjects/Account/";
    static Gson gson = new Gson();

    public AccountsApi() throws IOException {
    }


    @Step("API: Read Account")
    public Response getAccount(String accountId){
        log.info("Reading Account with id: " + accountId);
        return get(accountEndpoint.concat(accountId), HttpStatus.SC_OK);
    }

    @Step("API: Read non-existing account")
    public Response getDeletedAccount(String accountId){
        log.info("Reading deleted account");
        return get(accountEndpoint.concat(accountId), HttpStatus.SC_NOT_FOUND);
    }

    @Step("API: Create Account")
    public Response createAccount(Account account){
        log.info("Creating account from model: " + account.getAccountName());
        String body = gson.toJson(account);
        return post(accountEndpoint, HttpStatus.SC_CREATED, body);
    }

    @Step("API: Create Account")
    public Response createEmptyAccount(Account account){
        log.info("Creating account from model: " + account.getAccountName());
        String body = gson.toJson(account);
        return post(accountEndpoint, HttpStatus.SC_BAD_REQUEST, body);
    }

    @Step("API: Update Account")
    public Response updateAccount(String accountId, Account updatedAcc){
        log.info(String.format("Updating account %s with new name %s",
                accountId, updatedAcc.getAccountName()));
        String body = gson.toJson(updatedAcc);
        return patch(accountEndpoint.concat(accountId), HttpStatus.SC_NO_CONTENT, body);
    }

    @Step("API: Delete Account")
    public Response deleteAccount(String accountId){
        log.info("Deleting account: " + accountId);
        return delete(accountEndpoint.concat(accountId), HttpStatus.SC_NO_CONTENT);
    }

    @Step("API: Get Accounts List")
    public Response getAccountsList(){
        log.info("Getting list of existing accounts: ");
        return get(accountEndpoint,HttpStatus.SC_OK);
    }
}
