package UI.pages.contacts;

import UI.wrappers.AccountInfoParser;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class SingleContactPage {

    protected SelenideElement contactFullName = $x("//div[text()='Contact']/parent::h1/descendant::span[1]");
    protected SelenideElement contactTitle = $x("//p[text()='Title']");
    protected SelenideElement contactAccountName = $x("//p[text()='Account Name']");
    protected SelenideElement contactPhone = $x("//p[contains(text(),'Phone (2)')]");
    protected SelenideElement contactEmail = $x("//p[text()='Email']");

    @Step("Account Contact Fullname Field Exists")
    public boolean checkContactFullNameExists(){
        return contactFullName.exists();
    }

    @Step("Get Contact Fullname")
    public String getContactFullName(){
        log.debug("Contact full name: " + contactFullName.getText());
        return contactFullName.getText();
    }

    @Step("Get Contact Title")
    public String getContactTitle(){
        String contTitle = new AccountInfoParser(contactTitle.getText()).getDisplayedText();
        log.debug("Contact title: " + contTitle);
        return contTitle;
    }

    @Step("Get Contact Account Name")
    public String getContactAccountName(){
        String contAccName = new AccountInfoParser(contactAccountName.getText()).getLinkText();
        log.debug("Contact Phone: " + contAccName);
        return contAccName;
    }

    @Step("Get Contact Phone")
    public String getContactPhone(){
        String contPhone = new AccountInfoParser(contactPhone.getText()).getLinkText();
        log.debug("Contact Phone: " + contPhone);
        return contPhone;
    }

    @Step("Get Contact Email")
    public String getContactEmail(){
        String contEmail = new AccountInfoParser(contactEmail.getText()).getLinkText();
        log.debug("Contact Phone: " + contEmail);
        return contEmail;
    }

}
