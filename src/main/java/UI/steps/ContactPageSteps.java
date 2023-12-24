package UI.steps;

import UI.pages.contacts.CreateNewContactPage;
import UI.pages.contacts.SingleContactPage;
import UI.wrappers.Input;
import dto.ContactModel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import UI.pages.contacts.ContactsPage;
import org.testng.Assert;

@Log4j2
public class ContactPageSteps {

    private ContactsPage contactsPage = new ContactsPage();
    private CreateNewContactPage createNewContactPage = new CreateNewContactPage();
    private SingleContactPage singleContactPage = new SingleContactPage();

    @Step("Create New Complete Contact")
    public void createCompleteContact(ContactModel contact){
        log.info("Creating Contact with complete data from model: " + contact.getLastName());
        contactsPage.clickNewContactButton();
        createNewContactPage.enterCompleteData(contact);
        createNewContactPage.clickSaveButton();
    }

    @Step("Create New Necessary Contact")
    public void createEssentialContact(ContactModel contact){
        log.info("Creating Contact with only essential fields from model: " + contact.getLastName());
        contactsPage.clickNewContactButton();
        createNewContactPage.enterNecessaryData(contact);
        createNewContactPage.clickSaveButton();
    }

    @Step("Create Contact without necessary fields")
    public void createEmptyContact(){
        log.info("Creating contact without any data inputted");
        contactsPage.clickNewContactButton();
        createNewContactPage.clickSaveButton();
    }

    @Step("Check Account Exists")
    public boolean checkContactTitleExists(){
        log.info("Checking Contact Title Exists");
        return singleContactPage.checkContactFullNameExists();
    }

    @Step("Read Account")
    public void readContact(ContactModel contact){
        String fullname = String.format("%s %s", contact.getFirstName(),
                contact.getLastName());
        log.info("Openning contact: " + fullname);
        contactsPage.openContact(fullname);
    }

    @Step("Check Contact Exists")
    public boolean checkContactExists(ContactModel contact){
        String fullname = String.format("%s %s", contact.getFirstName(),
                contact.getLastName());
        log.info("Checking Contact exists: " + fullname);
        return contactsPage.checkContactExists(fullname);
    }

    @Step("Check All contact Fields")
    public void checkContactFields(ContactModel contact){
        String fullname = String.format("%s %s %s", contact.getSalutation(), contact.getFirstName(),
                contact.getLastName());
        log.info("Checking data fields of contact: " + fullname);
        Assert.assertEquals(singleContactPage.getContactFullName(),fullname);
        Assert.assertEquals(singleContactPage.getContactAccountName(),contact.getAccountName());
        Assert.assertEquals(singleContactPage.getContactEmail(),contact.getEmail());
        Assert.assertEquals(singleContactPage.getContactPhone(),contact.getPhone());
        Assert.assertEquals(singleContactPage.getContactTitle(),contact.getTitle());
    }

    @Step("Check Title Field")
    public void checkFullnameField(ContactModel contact){
        String fullname = String.format("%s %s %s", contact.getSalutation(), contact.getFirstName(),
                contact.getLastName());
        log.info("Checking Fullname field for contact: " + fullname);
        Assert.assertEquals(singleContactPage.getContactFullName(),fullname);
    }

    @Step("Check Contact Creation Error Artifacts")
    public void checkErrorMessages(){
        log.info("Checking that Error Icon and Error Message exist");
        Assert.assertTrue(createNewContactPage.checkObligatoryErrorIconExists());
        Assert.assertTrue(createNewContactPage.checkObligatoryErrorMessageExists());
    }

    @Step("Close Create contact Window")
    public void closeCreateContactWindow(){
        log.info("Closing Create contact window");
        createNewContactPage.clickCancelButton();
    }

    @Step("Edit existing account")
    public void editExistingContact(ContactModel contact, String newName){
        String fullname = String.format("%s %s %s", contact.getSalutation(), contact.getFirstName(),
                contact.getLastName());
        log.info("Editing Account: " + fullname);
        contactsPage.clickEditButton(contact);
        new Input("Account Name").edit(newName);
        createNewContactPage.clickSaveButton();
    }

    @Step("Delete existing account")
    public void deleteExistingAccount(ContactModel contact){
        String fullname = String.format("%s %s %s", contact.getSalutation(), contact.getFirstName(),
                contact.getLastName());
        log.info("Deleting Account: " + fullname);
        contactsPage.clickDeleteButton(contact);
        contactsPage.confirmDeleteButton();
    }


}
