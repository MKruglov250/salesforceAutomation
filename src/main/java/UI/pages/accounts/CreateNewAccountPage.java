package UI.pages.accounts;


import UI.wrappers.Dropdown;
import UI.wrappers.Input;
import com.codeborne.selenide.SelenideElement;
import dto.AccountModel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class CreateNewAccountPage extends SingleAccountPage {

    SelenideElement saveButton = $x("//button[@name='SaveEdit']");
    SelenideElement cancelButton = $x("//button[text()='Cancel']");
    SelenideElement errorMessage = $x("//h2[text()='We hit a snag.']");
    SelenideElement errorIcon = $x("//button[@id='window']");
    SelenideElement accountInfo = $x("//span[text()='Account Information']");

    @Step("Enter only necessary Account Data from Model")
    public void enterNecessaryData(AccountModel accountModel){
        accountInfo.shouldBe(visible);
        log.info("Entering model data to obligatory fields");
        new Input("Account Name").write(accountModel.getAccountName());
    }

    @Step("Enter full Account Data from Model")
    public void enterCompleteData(AccountModel accountModel){
        accountInfo.shouldBe(visible);
        log.info("Entering model data to all existing fields");
        new Dropdown("Rating").select(accountModel.getRating());
        new Input("Account Name").write(accountModel.getAccountName());
        //new InputWithSuggestion("Parent Account").inputSuggestion(accountModel.getParentAccount()); - can't beat it...
        new Input("Phone").write(accountModel.getPhone());
        new Input("Fax").write(accountModel.getFax());
        new Input("Account Number").write(accountModel.getAccountNumber());
        new Input("Website").write(accountModel.getWebsite());
        new Input("Account Site").write(accountModel.getAccountSite());
        new Input("Ticker Symbol").write(accountModel.getTickerSymbol());
        new Dropdown("Type").select(accountModel.getType());
        new Dropdown("Ownership").select(accountModel.getOwnership());
        new Dropdown("Industry").select(accountModel.getIndustry());
        new Input("Employees").write(accountModel.getEmployees());
        new Input("Annual Revenue").write(accountModel.getAnnualRevenue());
        new Input("SIC Code").write(accountModel.getSicCode());

        new Input("Billing Street").write(accountModel.getBillingStreet());
        new Input("Billing Zip/Postal Code").write(accountModel.getBillingZipCode());
        new Input("Billing City").write(accountModel.getBillingCity());
        new Input("Billing State/Province").write(accountModel.getBillingState());
        new Input("Billing Country").write(accountModel.getBillingCountry());

        new Input("Shipping Street").write(accountModel.getShippingStreet());
        new Input("Shipping Zip/Postal Code").write(accountModel.getShippingZipCode());
        new Input("Shipping City").write(accountModel.getShippingCity());
        new Input("Shipping State/Province").write(accountModel.getShippingState());
        new Input("Shipping Country").write(accountModel.getShippingCountry());

        new Dropdown("Customer Priority").select(accountModel.getPriority());
        new Dropdown("SLA").select(accountModel.getSla());
        new Dropdown("Upsell Opportunity").select(accountModel.getUpsell());
//        new Dropdown("Active").select(accountModel.getIsActive()); - some broken dropdown
        new Input("SLA Expiration Date").write(accountModel.getSlaExpiration());
        new Input("SLA Serial Number").write(accountModel.getSlaNumber());
        new Input("Number of Locations").write(accountModel.getNumberLocations());

        new Input("Description").write(accountModel.getDescription());
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