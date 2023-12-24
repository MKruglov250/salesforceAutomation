package dto;

import com.github.javafaker.Faker;
import utilities.AccountUtils;

public class AccountModelBuilder {

    public static AccountModel getFullAccount() {
        return new AccountModel.AccountModelBuilder()
                .accountName(AccountUtils.getAttribute("accountName"))
                .rating(AccountUtils.getAttribute("rating"))
                .parentAccount(AccountUtils.getAttribute("parentAccount"))
                .phone(AccountUtils.getAttribute("phone"))
                .fax(AccountUtils.getAttribute("fax"))
                .accountNumber(AccountUtils.getAttribute("accountNumber"))
                .website(AccountUtils.getAttribute("website"))
                .accountSite(AccountUtils.getAttribute("accountSite"))
                .tickerSymbol(AccountUtils.getAttribute("tickerSymbol"))
                .type(AccountUtils.getAttribute("type"))
                .industry(AccountUtils.getAttribute("industry"))
                .employees(AccountUtils.getAttribute("employees"))
                .annualRevenue(AccountUtils.getAttribute("annualRevenue"))
                .sicCode(AccountUtils.getAttribute("sicCode"))
                .billingStreet(AccountUtils.getAttribute("billingStreet"))
                .billingCity(AccountUtils.getAttribute("billingCity"))
                .billingZipCode(AccountUtils.getAttribute("billingZipCode"))
                .billingState(AccountUtils.getAttribute("billingState"))
                .billingCountry(AccountUtils.getAttribute("billingCountry"))
                .shippingStreet(AccountUtils.getAttribute("shippingStreet"))
                .shippingCity(AccountUtils.getAttribute("shippingCity"))
                .shippingZipCode(AccountUtils.getAttribute("shippingZipCode"))
                .shippingState(AccountUtils.getAttribute("shippingState"))
                .shippingCountry(AccountUtils.getAttribute("shippingCountry"))
                .priority(AccountUtils.getAttribute("priority"))
                .sla(AccountUtils.getAttribute("sla"))
                .slaExpiration(AccountUtils.getAttribute("slaExpiration"))
                .slaNumber(AccountUtils.getAttribute("slaNumber"))
                .numberLocations(AccountUtils.getAttribute("numberLocations"))
                .upsell(AccountUtils.getAttribute("upsell"))
                .isActive(AccountUtils.getAttribute("isActive"))
                .description(AccountUtils.getAttribute("description"))
                .ownership(AccountUtils.getAttribute("ownership"))
                .build();
    }


    public static AccountModel getEssentialAccount(){
        Faker faker = new Faker();

        return new AccountModel.AccountModelBuilder()
                .accountName(faker.funnyName().name())
                .build();
    }

    public static AccountModel getEditedAccount(){
        return new AccountModel.AccountModelBuilder()
                .accountName("Edited Account")
                .build();
    }
}
