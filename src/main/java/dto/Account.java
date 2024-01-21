package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String accountName;
    @SerializedName("Rating")
    private String rating;
    @SerializedName("ParentId")
    private String parentAccount;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("Fax")
    private String fax;
    @SerializedName("AccountNumber")
    private String accountNumber;
    @SerializedName("Website")
    private String website;
    @SerializedName("Site")
    private String accountSite;
    @SerializedName("TickerSymbol")
    private String tickerSymbol;
    @SerializedName("Type")
    private String type;
    @SerializedName("Industry")
    private String industry;
    @SerializedName("NumberOfEmployees")
    private String employees;
    @SerializedName("AnnualRevenue")
    private String annualRevenue;
    @SerializedName("Sic")
    private String sicCode;

    @SerializedName("BillingStreet")
    private String billingStreet;
    @SerializedName("BillingCity")
    private String billingCity;
    @SerializedName("BillingPostalCode")
    private String billingZipCode;
    @SerializedName("BillingState")
    private String billingState;
    @SerializedName("BillingCountry")
    private String billingCountry;

    @SerializedName("ShippingStreet")
    private String shippingStreet;
    @SerializedName("ShippingCity")
    private String shippingCity;
    @SerializedName("ShippingPostalCode")
    private String shippingZipCode;
    @SerializedName("ShippingState")
    private String shippingState;
    @SerializedName("ShippingCountry")
    private String shippingCountry;

    @SerializedName("Priority")
    private String priority;
    @SerializedName("SLA__c")
    private String sla;
    @SerializedName("SLAExpirationDate__c")
    private String slaExpiration;
    @SerializedName("SLASerialNumber__c")
    private String slaNumber;
    @SerializedName("NumberofLocations__c")
    private String numberLocations;
    @SerializedName("UpsellOpportunity__c")
    private String upsell;
    @SerializedName("Active__c")
    private String isActive;

    @SerializedName("Description")
    private String description;
    @SerializedName("Ownership")
    private String ownership;
}
