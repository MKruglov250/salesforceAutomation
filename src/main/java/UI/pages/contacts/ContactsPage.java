package UI.pages.contacts;

import com.codeborne.selenide.SelenideElement;
import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ContactsPage {

    private SelenideElement newContactButton = $x("//button[text()='New']");
    private SelenideElement editButton = $x("//a[@title='Edit']");
    private SelenideElement deleteButton = $x("//a[@title='Delete']");
    private SelenideElement confirmDeleteButton = $x("//button[@title='Delete']");

    @Step("Click New Contact button")
    public void clickNewContactButton(){
        log.info("Click New Account Button");
        newContactButton.click();
    }

    @Step("Open Account")
    public void openContact(String contactLabel){
        log.info("Opening contact: " + contactLabel);
        SelenideElement contact = $x(String.format("//a[@title='%s']",contactLabel));
        contact.scrollTo();
        contact.should(exist);
        contact.click();
    }

    @Step("Check contact exists on page")
    public boolean checkContactExists(String contactLabel){
        log.info("Checking contact exists on page: " + contactLabel);
        boolean contactExists = $x(String.format("//a[@title='%s']",contactLabel)).exists();
        log.info("Contact exists: " + contactExists);
        return contactExists;
    }

    @Step("Click Actions Button")
    public void clickActionsButton(Contact contact){
        $x(String.format("//a[@title='%s']/ancestor::tr//button[@aria-expanded='false']",
                contact.getFirstName() + " " + contact.getLastName())).scrollIntoView(true).click();
    }

    @Step("Click Edit button")
    public void clickEditButton(Contact contact){
        log.info("Clicking Edit button for contact: " + contact.getAccountName());
        clickActionsButton(contact);
        editButton.click();
    }

    @Step("Click Delete button")
    public void clickDeleteButton(Contact contact){
        log.info("Clicking Delete button for contact: " + contact.getAccountName());
        clickActionsButton(contact);
        deleteButton.click();
    }

    @Step("Confirm Delete button")
    public void confirmDeleteButton(){
        log.info("Confirming Deletion");
        confirmDeleteButton.click();
    }

}
