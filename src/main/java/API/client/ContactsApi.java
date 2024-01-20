package API.client;

import API.base.BaseApi;
import com.google.gson.Gson;
import dto.ContactModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import java.io.IOException;

@Log4j2
public class ContactsApi extends BaseApi {

    static String contactEndpoint = "services/data/v59.0/sobjects/Contact/";
    static Gson gson = new Gson();

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
    public Response createContact(ContactModel contact){
        log.info("Creating contact from model: " + contact.getLastName());
        String body = gson.toJson(contact);
        return post(contactEndpoint, HttpStatus.SC_CREATED, body);
    }

    @Step("API: Create contact")
    public Response createEmptyContact(ContactModel contact){
        log.info("Creating contact from model: " + contact.getLastName());
        String body = gson.toJson(contact);
        return post(contactEndpoint, HttpStatus.SC_BAD_REQUEST, body);
    }

    @Step("API: Update contact")
    public Response updateContact(String accountId, ContactModel updatedContact){
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

    @Step("API: Get Contacts List")
    public Response getContactsList(){
        log.info("Getting list of existing accounts: ");
        return get(contactEndpoint,HttpStatus.SC_OK);
    }
}
