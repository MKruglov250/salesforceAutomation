package dto;

import com.github.javafaker.Faker;
import utilities.AccountUtils;

public class ContactModelBuilder {

    public static ContactModel getFullAccount() {
        return new ContactModel.ContactModelBuilder()
                .id(AccountUtils.getAttribute("id"))
                .salutation(AccountUtils.getAttribute("salutation"))
                .firstName(AccountUtils.getAttribute("firstName"))
                .lastName(AccountUtils.getAttribute("lastName"))
                .phone(AccountUtils.getAttribute("phone"))
                .homePhone(AccountUtils.getAttribute("homePhone"))
                .accountName(AccountUtils.getAttribute("accountName"))
                .title(AccountUtils.getAttribute("title"))
                .department(AccountUtils.getAttribute("department"))
                .mobile(AccountUtils.getAttribute("mobile"))
                .otherPhone(AccountUtils.getAttribute("otherPhone"))
                .fax(AccountUtils.getAttribute("fax"))
                .birthdate(AccountUtils.getAttribute("birthdate"))
                .email(AccountUtils.getAttribute("email"))
                .reportsTo(AccountUtils.getAttribute("reportsTo"))
                .assistant(AccountUtils.getAttribute("assistant"))
                .assistantPhone(AccountUtils.getAttribute("assistantPhone"))
                .leadSource(AccountUtils.getAttribute("leadSource"))
                .mailingStreet(AccountUtils.getAttribute("mailingStreet"))
                .mailingCity(AccountUtils.getAttribute("mailingCity"))
                .mailingZipCode(AccountUtils.getAttribute("mailingZipCode"))
                .mailingState(AccountUtils.getAttribute("mailingState"))
                .mailingCountry(AccountUtils.getAttribute("mailingCountry"))
                .otherStreet(AccountUtils.getAttribute("otherStreet"))
                .otherCity(AccountUtils.getAttribute("otherCity"))
                .otherZipCode(AccountUtils.getAttribute("otherZipCode"))
                .otherState(AccountUtils.getAttribute("otherState"))
                .otherCountry(AccountUtils.getAttribute("otherCountry"))
                .languages(AccountUtils.getAttribute("languages"))
                .level(AccountUtils.getAttribute("level"))
                .description(AccountUtils.getAttribute("description"))
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
