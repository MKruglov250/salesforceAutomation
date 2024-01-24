package dto;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import utilities.AccountUtils;
import utilities.ContactUtils;

import java.io.IOException;

public class ContactBuilder {

    public static Contact getFullAccount() {
        return new Contact.ContactBuilder()
                .salutation(ContactUtils.getAttribute("salutation"))
                .firstName(ContactUtils.getAttribute("firstName"))
                .lastName(ContactUtils.getAttribute("lastName"))
                .phone(ContactUtils.getAttribute("phone"))
                .homePhone(ContactUtils.getAttribute("homePhone"))
                .accountName(ContactUtils.getAttribute("accountName"))
                .title(ContactUtils.getAttribute("title"))
                .department(ContactUtils.getAttribute("department"))
                .mobile(ContactUtils.getAttribute("mobile"))
                .otherPhone(ContactUtils.getAttribute("otherPhone"))
                .fax(ContactUtils.getAttribute("fax"))
                .birthdate(ContactUtils.getAttribute("birthdate"))
                .email(ContactUtils.getAttribute("email"))
                .reportsTo(ContactUtils.getAttribute("reportsTo"))
                .assistant(ContactUtils.getAttribute("assistant"))
                .assistantPhone(ContactUtils.getAttribute("assistantPhone"))
                .leadSource(ContactUtils.getAttribute("leadSource"))
                .mailingStreet(ContactUtils.getAttribute("mailingStreet"))
                .mailingCity(ContactUtils.getAttribute("mailingCity"))
                .mailingZipCode(ContactUtils.getAttribute("mailingZipCode"))
                .mailingState(ContactUtils.getAttribute("mailingState"))
                .mailingCountry(ContactUtils.getAttribute("mailingCountry"))
                .otherStreet(ContactUtils.getAttribute("otherStreet"))
                .otherCity(ContactUtils.getAttribute("otherCity"))
                .otherZipCode(ContactUtils.getAttribute("otherZipCode"))
                .otherState(ContactUtils.getAttribute("otherState"))
                .otherCountry(ContactUtils.getAttribute("otherCountry"))
                .languages(ContactUtils.getAttribute("languages"))
                .level(ContactUtils.getAttribute("level"))
                .description(ContactUtils.getAttribute("description"))
                .build();
    }


    public static Contact getEssentialContact(){
        Faker faker = new Faker();

        return new Contact.ContactBuilder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .build();
    }

    public static Contact getEssentialContact(String firstname, String lastname){

        return new Contact.ContactBuilder()
                .lastName(lastname)
                .firstName(firstname)
                .build();
    }

    public static Contact getEditedContact(){
        return new Contact.ContactBuilder()
                .lastName("Edited")
                .firstName("Contact")
                .build();
    }

    public static Contact getEmptyContact(){
        return new Contact.ContactBuilder()
                .description("Test Desc")
                .build();
    }

    public static Contact getApiContact() throws IOException, ParseException {
        Gson gson = new Gson();
        return gson.fromJson(AccountUtils.parseJson("apiContact.json"), Contact.class);
    }
}
