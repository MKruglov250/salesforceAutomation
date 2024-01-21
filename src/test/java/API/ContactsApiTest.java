package API;

import API.client.ContactsApi;
import com.google.gson.Gson;
import dto.Contact;
import dto.ContactBuilder;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Log4j2
public class ContactsApiTest {

    Gson gson = new Gson();
    ContactsApi contactsApi = new ContactsApi();
    Contact contact = ContactBuilder.getApiContact();
    Contact editedContact = ContactBuilder.getEditedContact();
    Contact emptyContact = ContactBuilder.getEmptyContact();
    static String newContactId;

    public ContactsApiTest() throws IOException, ParseException {
    }

    @Test(description = "Create New Contact", groups = "Smoke")
    public void createContactTest(){
        log.info("Test: create new contact");
        Response response = contactsApi.createContact(contact);
        contact.setId(response.body().jsonPath().getString("id"));
        newContactId = contact.getId();
        Assert.assertEquals(response.body().jsonPath().getString("success"),"true");
    }

    @Test(description = "Create Empty Contact", groups = "Regression")
    public void createEmptyContactTest(){
        log.info("Test: create empty contact");
        Response response = contactsApi.createEmptyContact(emptyContact);
        Assert.assertEquals(response.body().jsonPath().getString("message"),
                "[Required fields are missing: [LastName]]");
        Assert.assertEquals(response.body().jsonPath().getString("errorCode"),
                "[REQUIRED_FIELD_MISSING]");
    }


    @Test(description = "Read Existing Contact", groups = "Smoke")
    public void readContactTest(){
        log.info("Test: read existing contact");
        Response response = contactsApi.getContact(newContactId);
        Assert.assertEquals(gson.fromJson(response.body().asString(), Contact.class),
                contact);
    }

    @Test(description = "Update Existing Contact", groups = "Regression", priority = 1)
    public void updateContactTest(){
        log.info("Test: update existing contact");
        contactsApi.updateContact(newContactId,editedContact);
        Response response = contactsApi.getContact(newContactId);
        String contactName = editedContact.getFirstName() + " " + editedContact.getLastName();
        Assert.assertEquals(response.body().jsonPath().getString("Name"),
                contactName);
    }

    @Test(description = "Get list of contacts", groups = "Smoke", priority = 2)
    public void getContactsListTest(){
        log.info("Test: get list of existing contacts");
        Response response = contactsApi.getContactsList();
        String recentAccount = gson.toJson(response.body().jsonPath()
                .getList("recentItems").get(0));
        Assert.assertTrue(recentAccount.contains("Edited, Contact"));
    }

    @Test(description = "Delete Existing Contact", groups = "Regression", priority = 3)
    public void deleteContactTest(){
        log.info("Test: delete existing contact");
        contactsApi.deleteContact(newContactId);
        Response response = contactsApi.getDeletedContact(newContactId);
        Assert.assertEquals(response.statusCode(),
                HttpStatus.SC_NOT_FOUND);
    }
}
