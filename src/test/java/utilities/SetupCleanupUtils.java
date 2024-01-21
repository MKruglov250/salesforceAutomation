package utilities;

import API.client.AccountsApi;
import API.client.ContactsApi;
import dto.Account;
import dto.AccountBuilder;
import dto.Contact;
import dto.ContactBuilder;
import io.qameta.allure.Step;

import java.io.IOException;

public class SetupCleanupUtils {

    static AccountsApi accountsApi;
    static ContactsApi contactsApi;

    static {
        try {
            contactsApi = new ContactsApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    static Contact contactRayBan = ContactBuilder.getEssentialContact("Saul","Badguy");
    static Contact contactToEdit = ContactBuilder.getEssentialContact("TO","EDIT");
    static Contact contactToDelete = ContactBuilder.getEssentialContact("TO","DELETE");

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

    @Step("Setup: create test contacts")
    public static void createTestContacts(){
        contactsApi.createContact(contactRayBan);
        contactsApi.createContact(contactToEdit);
        contactsApi.createContact(contactToDelete);
    }

    @Step("Cleanup: deleting all test accounts")
    public static void deleteRecentAccounts(){
        accountsApi.deleteRecentAccounts();
    }

    @Step("Cleanup: deleting all test contacts")
    public static void deleteRecentContacts(){
        contactsApi.deleteRecentContacts();
    }
}
