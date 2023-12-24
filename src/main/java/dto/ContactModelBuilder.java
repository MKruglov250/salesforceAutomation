package dto;

import com.github.javafaker.Faker;
import utilities.AccountUtils;
import utilities.ContactUtils;

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
                .build();
    }

    public static ContactModel getEditedContact(){
        return new ContactModel.ContactModelBuilder()
                .accountName("Edited Contact")
                .build();
    }
}
