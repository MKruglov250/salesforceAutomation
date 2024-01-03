package API.client;

import API.base.BaseApi;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import java.io.IOException;

@Log4j2
public class AccountsApi extends BaseApi {

    static String accountEndpoint = "services/data/v59.0/sobjects/Account/";

    public AccountsApi() throws IOException {
    }

    public Response getAccount(String accountId){
        log.info("Reading Account with ");
        accountId = "001Wy000000WzjYIAS";
        return get(accountEndpoint.concat(accountId), HttpStatus.SC_OK);
    }
}
