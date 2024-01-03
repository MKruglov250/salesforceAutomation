package API.client;

import API.base.BaseApi;
import com.google.gson.Gson;
import dto.AccountModel;
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

    public Response getAccount(String accountId){
        log.info("Reading Account with id: " + accountId);
        accountId = "001Wy000000WzjYIAS";
        return get(accountEndpoint.concat(accountId), HttpStatus.SC_OK);
    }

    public Response createAccount(AccountModel account){
        log.info("Creating account from model: " + account.getAccountName());
        String body = gson.toJson(account);
        return post(accountEndpoint, HttpStatus.SC_CREATED, body);
    }
}
