package dto;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import utilities.AccountUtils;
import utilities.ContactUtils;

import java.io.IOException;

public class ContactModelBuilder {

    public static ContactModel getFullAccount() {
        return new ContactModel.ContactModelBuilder()
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


    public static ContactModel getEssentialContact(){
        Faker faker = new Faker();

        return new ContactModel.ContactModelBuilder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .build();
    }

    public static ContactModel getEditedContact(){
        return new ContactModel.ContactModelBuilder()
                .lastName("Edited")
                .firstName("Contact")
                .build();
    }

    public static ContactModel getEmptyContact(){
        return new ContactModel.ContactModelBuilder()
                .description("Test Desc")
                .build();
    }

    public static ContactModel getApiContact() throws IOException, ParseException {
        Gson gson = new Gson();
        return gson.fromJson(AccountUtils.parseJson("apiContact.json"),ContactModel.class);
    }
}
