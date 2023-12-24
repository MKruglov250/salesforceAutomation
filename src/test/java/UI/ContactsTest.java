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

}
