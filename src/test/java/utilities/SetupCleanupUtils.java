package utilities;

import API.client.AccountsApi;
import API.client.ContactsApi;
import dto.Account;
import dto.AccountBuilder;
import io.qameta.allure.Step;

import java.io.IOException;

public class SetupCleanupUtils {

    static AccountsApi accountsApi;
    static ContactsApi contactsApi;

    static {
        try {
            accountsApi = new AccountsApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Account accJohnDoe = AccountBuilder.getEssentialAccount("John Doe");
    static Account accDuke = AccountBuilder.getEssentialAccount("Duke de France");
    static Account accToEdit = AccountBuilder.getEssentialAccount("NOT YET EDITED");
    static Account accToDelete = AccountBuilder.getEssentialAccount("TO DELETE");

    public SetupCleanupUtils(){
    }

    @Step("Setup: creating test accounts")
    public static void createTestAccounts(){
        accountsApi.createAccount(accDuke);
        accountsApi.createAccount(accToEdit);
        accountsApi.createAccount(accToDelete);
    }

    @Step("Setup: create test account for Contacts test")
    public static void createJohnDoeAccount(){
        accountsApi.createAccount(accJohnDoe);
    }

    @Step("Cleanup: deleting all test accounts")
    public static void deleteRecentAccounts(){
        accountsApi.deleteRecentAccounts();
    }

}
