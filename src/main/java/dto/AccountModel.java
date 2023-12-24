package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountModel {
    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String accountName;
    private String rating;
    private String parentAccount;
    private String phone;
    private String fax;
    private String accountNumber;
    private String website;
    private String accountSite;
    private String tickerSymbol;
    private String type;
    private String industry;
    private String employees;
    private String annualRevenue;
    private String sicCode;

    private String billingStreet;
    private String billingCity;
    private String billingZipCode;
    private String billingState;
    private String billingCountry;

    private String shippingStreet;
    private String shippingCity;
    private String shippingZipCode;
    private String shippingState;
    private String shippingCountry;

    private String priority;
    private String sla;
    private String slaExpiration;
    private String slaNumber;
    private String numberLocations;
    private String upsell;
    private String isActive;

    private String description;
    private String ownership;
}
