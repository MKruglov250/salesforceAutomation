package UI.pages.accounts;


import UI.wrappers.Dropdown;
import UI.wrappers.Input;
import UI.wrappers.InputWithSuggestion;
import com.codeborne.selenide.SelenideElement;
import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class CreateNewAccountPage extends SingleAccountPage {

    protected SelenideElement saveButton = $x("//button[@name='SaveEdit']");
    protected SelenideElement cancelButton = $x("//button[text()='Cancel']");
    protected SelenideElement errorMessage = $x("//h2[text()='We hit a snag.']");
    protected SelenideElement errorIcon = $x("//button[@id='window']");
    protected SelenideElement accountInfo = $x("//span[text()='Account Information']");

    @Step("Enter only necessary Account Data from Model")
    public void enterNecessaryData(Account account){
        accountInfo.shouldBe(visible);
        log.info("Entering model data to obligatory fields");
        new Input("Account Name").write(account.getAccountName());
    }

    @Step("Enter full Account Data from Model")
    public void enterCompleteData(Account account){
        accountInfo.shouldBe(visible);
        log.info("Entering model data to all existing fields");
        new Dropdown("Rating").select(account.getRating());
        new Input("Account Name").write(account.getAccountName());
        new InputWithSuggestion("Parent Account").inputSuggestion(account.getParentAccount());
        new Input("Phone").write(account.getPhone());
        new Input("Fax").write(account.getFax());
        new Input("Account Number").write(account.getAccountNumber());
        new Input("Website").write(account.getWebsite());
        new Input("Account Site").write(account.getAccountSite());
        new Input("Ticker Symbol").write(account.getTickerSymbol());
        new Dropdown("Type").select(account.getType());
        new Dropdown("Ownership").select(account.getOwnership());
        new Dropdown("Industry").select(account.getIndustry());
        new Input("Employees").write(account.getEmployees());
        new Input("Annual Revenue").write(account.getAnnualRevenue());
        new Input("SIC Code").write(account.getSicCode());

        new Input("Billing Street").write(account.getBillingStreet());
        new Input("Billing Zip/Postal Code").write(account.getBillingZipCode());
        new Input("Billing City").write(account.getBillingCity());
        new Input("Billing State/Province").write(account.getBillingState());
        new Input("Billing Country").write(account.getBillingCountry());

        new Input("Shipping Street").write(account.getShippingStreet());
        new Input("Shipping Zip/Postal Code").write(account.getShippingZipCode());
        new Input("Shipping City").write(account.getShippingCity());
        new Input("Shipping State/Province").write(account.getShippingState());
        new Input("Shipping Country").write(account.getShippingCountry());

        new Dropdown("Customer Priority").select(account.getPriority());
        new Dropdown("SLA").select(account.getSla());
        new Dropdown("Upsell Opportunity").select(account.getUpsell());
        new Input("SLA Expiration Date").write(account.getSlaExpiration());
        new Input("SLA Serial Number").write(account.getSlaNumber());
        new Input("Number of Locations").write(account.getNumberLocations());

        new Input("Description").write(account.getDescription());
    }

    @Step("Click Save button")
    public void clickSaveButton(){
        log.info("Clicking Save button");
        saveButton.click();
    }

    @Step("Click Cancel button")
    public void clickCancelButton(){
        log.info("Clicking Cancel button");
        cancelButton.click();
    }

    @Step("Check obligatory field Error Message exists")
    public boolean checkObligatoryErrorMessageExists(){
        log.info("Checking Obligatory error message exists");
        boolean messageExists = errorMessage.exists();
        log.info("Obligatory message exists: " + messageExists);
        return messageExists;
    }

    @Step("Check obligatory field Error Icon exists")
    public boolean checkObligatoryErrorIconExists(){
        log.info("Checking Obligatory error icon exists");
        boolean iconExists = errorIcon.exists();
        log.info("Obligatory icon exists: " + iconExists);
        return iconExists;
    }

}