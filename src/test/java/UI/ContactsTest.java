package UI;

import dto.ContactModel;
import dto.ContactModelBuilder;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class ContactsTest extends BaseTest{

    ContactModel completeContact = ContactModelBuilder.getFullAccount();
    ContactModel essentialContact = ContactModelBuilder.getEssentialContact();
    ContactModel editedContact = ContactModelBuilder.getEditedContact();

    @BeforeMethod(description = "Login and switch to Contacts tab", alwaysRun = true)
    public void setUp(){
        log.info("Logging in and opening Accounts tab");
        loginPageSteps.loginToSite(validUser);
        navigationSteps.switchToServicesScreen();
        navigationSteps.switchToContactsTab();
    }

    @AfterMethod
    public void logout(){
        loginPageSteps.logout();
    }

    @Test(description = "Check Complete Contact creation", groups = "Smoke")
    public void checkCreateFullContact(){
        log.info("Test: create contact with all data fields");
        contactPageSteps.createCompleteContact(completeContact);

        Assert.assertTrue(accountPageSteps.checkAccountTitleExists());
    }

    @Test(description = "Check Read Created Contact", groups = "Smoke")
    public void checkReadContact(){
        log.info("Test: read existing contact, check main fields data correct");
        contactPageSteps.readContact(completeContact);

        contactPageSteps.checkContactFields(completeContact);
    }

    @Test(description = "Check Creation of empty contact has errors", groups = "Regression")
    public void checkEmptyContactCreation(){
        log.info("Test: create contact with no data, check errors appear");
        contactPageSteps.createEmptyContact();

        contactPageSteps.checkErrorMessages();

        contactPageSteps.closeCreateContactWindow();
    }

    @Test(description = "Check Create Account with only essential fields", groups = "Smoke")
    public void checkCreateEssentialAccount(){
        log.info("Test: create account with only essential fields");
        contactPageSteps.createEssentialContact(essentialContact);

        contactPageSteps.checkShortFullname(essentialContact);
    }

    @Test(description = "Check Edit Contact", groups = "Regression", priority = 1)
    public void checkEditContact(){
        log.info("Test: edit existing contact first and last name");
        contactPageSteps.editExistingContact(essentialContact, editedContact);
        Assert.assertTrue(contactPageSteps.checkContactExists(editedContact));
    }

    @Test(description = "Check Delete Complete Contact", groups = "Regression",
            priority = 2)
    public void checkDeleteCompleteContact(){
        log.info("Test: delete complete contact");
        contactPageSteps.deleteExistingContact(completeContact);

        Assert.assertTrue(contactPageSteps.checkContactExists(completeContact));
    }

    @Test(description = "Check Delete Edited Contact", groups = "Regression",
            priority = 2)
    public void checkDeleteEditedContact(){
        log.info("Test: delete edited Contact");
        contactPageSteps.deleteExistingContact(editedContact);

        Assert.assertTrue(contactPageSteps.checkContactExists(editedContact));
    }

}
