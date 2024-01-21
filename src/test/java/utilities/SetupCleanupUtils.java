package utilities;

import API.client.AccountsApi;
import dto.AccountModel;
import dto.AccountModelBuilder;

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

    static AccountModel accJohnDoe = AccountModelBuilder.getEssentialAccount("Duke de France");
    static AccountModel accToEdit = AccountModelBuilder.getEssentialAccount("NOT YET EDITED");
    static AccountModel accToDelete = AccountModelBuilder.getEssentialAccount("TO DELETE");

    public SetupCleanupUtils(){
    }

    public static void createTestAccounts(){
        accountsApi.createAccount(accJohnDoe);
        accountsApi.createAccount(accToEdit);
        accountsApi.createAccount(accToDelete);
    }
    public static void createTestContacts(){

    }

}
