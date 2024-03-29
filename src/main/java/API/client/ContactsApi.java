package API.client;

import API.base.BaseApi;
import API.dto.ContactsList;
import com.google.gson.Gson;
import dto.Contact;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;

@Log4j2
public class ContactsApi extends BaseApi {

    private static String contactEndpoint = "services/data/v59.0/sobjects/Contact/";
    private static Gson gson = new Gson();

    public ContactsApi() throws IOException {
    }

    @Step("API: Read contact")
    public Response getContact(String contactId){
        log.info("Reading contact with id: " + contactId);
        return get(contactEndpoint.concat(contactId), HttpStatus.SC_OK);
    }

    @Step("API: Read non-existing contact")
    public Response getDeletedContact(String contactId){
        log.info("Reading deleted contact");
        return get(contactEndpoint.concat(contactId), HttpStatus.SC_NOT_FOUND);
    }

    @Step("API: Create contact")
    public Response createContact(Contact contact){
        log.info("Creating contact from model: " + contact.getLastName());
        String body = gson.toJson(contact);
        return post(contactEndpoint, HttpStatus.SC_CREATED, body);
    }

    @Step("API: Create contact")
    public Response createEmptyContact(Contact contact){
        log.info("Creating contact from model: " + contact.getLastName());
        String body = gson.toJson(contact);
        return post(contactEndpoint, HttpStatus.SC_BAD_REQUEST, body);
    }

    @Step("API: Update contact")
    public Response updateContact(String accountId, Contact updatedContact){
        log.info(String.format("Updating contact %s with new name %s",
                accountId, updatedContact.getLastName()));
        String body = gson.toJson(updatedContact);
        return patch(contactEndpoint.concat(accountId), HttpStatus.SC_NO_CONTENT, body);
    }

    @Step("API: Delete contact")
    public Response deleteContact(String contactId){
        log.info("Deleting contact: " + contactId);
        return delete(contactEndpoint.concat(contactId), HttpStatus.SC_NO_CONTENT);
    }

    @Step("API: Get Contacts List as response")
    public Response getContactsList(){
        log.info("Getting list of existing contacts");
        return get(contactEndpoint,HttpStatus.SC_OK);
    }

    @Step("API: Get contacts List as class")
    public ContactsList getContactsListClass(){
        log.info("Getting list of existing contacts as class");
        Response response = get(contactEndpoint,HttpStatus.SC_OK);
        return gson.fromJson(response.body().asString(), ContactsList.class);
    }

    @Step("API: delete recent contacts")
    public void deleteRecentContacts() {
        ArrayList<Contact> contactsList = getContactsListClass().getContactsList();
        for (Contact contact : contactsList) {
            deleteContact(contact.getId());
        }
        log.info("Recent contacts deleted");
    }
}
