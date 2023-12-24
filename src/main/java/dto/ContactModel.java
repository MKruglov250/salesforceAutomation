package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactModel {
    @SerializedName("Id")
    private String id;
    private String salutation;
    private String firstName;
    private String lastName;
    private String phone;
    private String homePhone;

    private String accountName;
    private String title;
    private String department;
    private String mobile;
    private String otherPhone;
    private String fax;
    private String birthdate;
    private String email;
    private String reportsTo;
    private String assistant;
    private String assistantPhone;
    private String leadSource;

    private String mailingStreet;
    private String mailingCity;
    private String mailingZipCode;
    private String mailingState;
    private String mailingCountry;

    private String otherStreet;
    private String otherCity;
    private String otherZipCode;
    private String otherState;
    private String otherCountry;

    private String languages;
    private String level;

    private String description;
}
