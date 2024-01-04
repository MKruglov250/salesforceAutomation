package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactModel {
    @SerializedName("Id")
    private String id;
    @SerializedName("Salutation")
    private String salutation;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("HomePhone")
    private String homePhone;

    @SerializedName("AccountName")
    private String accountName;
    @SerializedName("Title")
    private String title;
    @SerializedName("Department")
    private String department;
    @SerializedName("MobilePhone")
    private String mobile;
    @SerializedName("OtherPhone")
    private String otherPhone;
    @SerializedName("Fax")
    private String fax;
    @SerializedName("Birthdate")
    private String birthdate;
    @SerializedName("Email")
    private String email;
    @SerializedName("ReportsToId")
    private String reportsTo;
    @SerializedName("AssistantName")
    private String assistant;
    @SerializedName("AssistantPhone")
    private String assistantPhone;
    @SerializedName("LeadSource")
    private String leadSource;

    @SerializedName("MailingStreet")
    private String mailingStreet;
    @SerializedName("MailingCity")
    private String mailingCity;
    @SerializedName("MailingPostalCode")
    private String mailingZipCode;
    @SerializedName("MailingState")
    private String mailingState;
    @SerializedName("MailingCountry")
    private String mailingCountry;

    @SerializedName("OtherStreet")
    private String otherStreet;
    @SerializedName("OtherCity")
    private String otherCity;
    @SerializedName("OtherPostalCode")
    private String otherZipCode;
    @SerializedName("OtherState")
    private String otherState;
    @SerializedName("OtherCountry")
    private String otherCountry;

    @SerializedName("Languages__c")
    private String languages;
    @SerializedName("Level__c")
    private String level;

    @SerializedName("Description")
    private String description;
}
