package UI.pages.contacts;

import UI.wrappers.Dropdown;
import UI.wrappers.Input;
import UI.wrappers.InputWithSuggestion;
import com.codeborne.selenide.SelenideElement;
import dto.ContactModel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class CreateNewContactPage {

    SelenideElement saveButton = $x("//button[@name='SaveEdit']");
    SelenideElement cancelButton = $x("//button[text()='Cancel']");
    SelenideElement errorMessage = $x("//h2[text()='We hit a snag.']");
    SelenideElement errorIcon = $x("//button[@id='window']");
    SelenideElement contactInfo = $x("//span[text()='Contact Information']");


    @Step("Enter only necessary Contact Data from Model")
    public void enterNecessaryData(ContactModel contactModel){
        contactInfo.shouldBe(visible);
        log.info("Entering model data to obligatory fields");
        new Input("Last Name").write(contactModel.getAccountName());
    }

    @Step("Enter full Contact Data from Model")
    public void enterCompleteData(ContactModel contactModel){
        contactInfo.shouldBe(visible);
        log.info("Entering model data to all existing fields");
        new Dropdown("Salutation").select(contactModel.getSalutation());
        new Input("First Name").write(contactModel.getFirstName());
        new InputWithSuggestion("Account Name").inputSuggestion("John Doe");
        //new InputWithSuggestion("Parent Account").inputSuggestion(accountModel.getParentAccount()); - can't beat it...
        new Input("Last Name").write(contactModel.getLastName());
        new Input("Phone").write(contactModel.getPhone());
        new Input("Home Phone").write(contactModel.getHomePhone());
        new Input("Title").write(contactModel.getTitle());
        new Input("Department").write(contactModel.getDepartment());
        new Input("Birthdate").write(contactModel.getBirthdate());
        new Dropdown("Lead Source").select(contactModel.getLeadSource());
        new Input("Mobile").write(contactModel.getMobile());
        new Input("Other Phone").write(contactModel.getOtherPhone());
        new Input("Fax").write(contactModel.getFax());
        new Input("Email").write(contactModel.getEmail());
        new Input("Assistant").write(contactModel.getAssistant());
        new Input("Asst. Phone").write(contactModel.getAssistantPhone());

        new Input("Mailing Street").write(contactModel.getMailingStreet());
        new Input("Mailing Zip/Postal Code").write(contactModel.getMailingZipCode());
        new Input("Mailing City").write(contactModel.getMailingCity());
        new Input("Mailing State/Province").write(contactModel.getMailingState());
        new Input("Mailing Country").write(contactModel.getMailingCountry());

        new Input("Other Street").write(contactModel.getOtherStreet());
        new Input("Other Zip/Postal Code").write(contactModel.getOtherZipCode());
        new Input("Other City").write(contactModel.getOtherCity());
        new Input("Other State/Province").write(contactModel.getOtherState());
        new Input("Other Country").write(contactModel.getOtherCountry());

        new Dropdown("Level").select(contactModel.getLevel());
        new Input("Languages").write(contactModel.getLanguages());

        new Input("Description").write(contactModel.getDescription());
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
