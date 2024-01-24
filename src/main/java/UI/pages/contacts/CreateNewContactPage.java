package UI.pages.contacts;

import UI.wrappers.Dropdown;
import UI.wrappers.Input;
import UI.wrappers.InputWithSuggestion;
import com.codeborne.selenide.SelenideElement;
import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class CreateNewContactPage {

    private SelenideElement saveButton = $x("//button[@name='SaveEdit']");
    private SelenideElement cancelButton = $x("//button[text()='Cancel']");
    private SelenideElement errorMessage = $x("//h2[text()='We hit a snag.']");
    private SelenideElement errorIcon = $x("//button[@id='window']");
    private SelenideElement contactInfo = $x("//span[text()='Contact Information']");


    @Step("Enter only necessary Contact Data from Model")
    public void enterNecessaryData(Contact contact){
        contactInfo.shouldBe(visible);
        log.info("Entering model data to obligatory fields");
        new Input("Last Name").write(contact.getLastName());
        new Input("First Name").write(contact.getFirstName());
    }

    @Step("Enter full Contact Data from Model")
    public void enterCompleteData(Contact contact){
        contactInfo.shouldBe(visible);
        log.info("Entering model data to all existing fields");
        new Dropdown("Salutation").select(contact.getSalutation());
        new Input("First Name").write(contact.getFirstName());
        new InputWithSuggestion("Account Name").inputSuggestion("John Doe");
        //new InputWithSuggestion("Parent Account").inputSuggestion(accountModel.getParentAccount()); - can't beat it...
        new Input("Last Name").write(contact.getLastName());
        new Input("Phone").write(contact.getPhone());
        new Input("Home Phone").write(contact.getHomePhone());
        new Input("Title").write(contact.getTitle());
        new Input("Department").write(contact.getDepartment());
        new Input("Birthdate").write(contact.getBirthdate());
        new Dropdown("Lead Source").select(contact.getLeadSource());
        new Input("Mobile").write(contact.getMobile());
        new Input("Other Phone").write(contact.getOtherPhone());
        new Input("Fax").write(contact.getFax());
        new Input("Email").write(contact.getEmail());
        new Input("Assistant").write(contact.getAssistant());
        new Input("Asst. Phone").write(contact.getAssistantPhone());

        new Input("Mailing Street").write(contact.getMailingStreet());
        new Input("Mailing Zip/Postal Code").write(contact.getMailingZipCode());
        new Input("Mailing City").write(contact.getMailingCity());
        new Input("Mailing State/Province").write(contact.getMailingState());
        new Input("Mailing Country").write(contact.getMailingCountry());

        new Input("Other Street").write(contact.getOtherStreet());
        new Input("Other Zip/Postal Code").write(contact.getOtherZipCode());
        new Input("Other City").write(contact.getOtherCity());
        new Input("Other State/Province").write(contact.getOtherState());
        new Input("Other Country").write(contact.getOtherCountry());

        new Dropdown("Level").select(contact.getLevel());
        new Input("Languages").write(contact.getLanguages());

        new Input("Description").write(contact.getDescription());
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
