package utilities;

import API.client.AccountsApi;
import dto.Account;
import dto.AccountBuilder;
import io.qameta.allure.Step;

import java.io.IOException;

public class SetupCleanupUtils {

    static AccountsApi accountsApi;

    static {
        try {
            accountsApi = new AccountsApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Account accJohnDoe = AccountBuilder.getEssentialAccount("Duke de France");
    static Account accToEdit = AccountBuilder.getEssentialAccount("NOT YET EDITED");
    static Account accToDelete = AccountBuilder.getEssentialAccount("TO DELETE");

    public SetupCleanupUtils(){
    }

    @Step("Setup: creating test accounts")
    public static void createTestAccounts(){
        accountsApi.createAccount(accJohnDoe);
        accountsApi.createAccount(accToEdit);
        accountsApi.createAccount(accToDelete);
    }

    @Step("Cleanup: deleting all test accounts")
    public static void deleteRecentAccounts(){
        accountsApi.deleteRecentAccounts();
    }
    public static void createTestContacts(){

    }

}
