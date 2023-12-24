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
    protected SelenideElement contactPhone = $x("//p[text()='Phone (2) ']");
    protected SelenideElement contactEmail = $x("//p[text()='Email']");

    @Step("Account Contact Fullname Field Exists")
    public boolean checkContactFullNameExists(){
        return contactFullName.exists();
    }

    @Step("Get Account Title")
    public String getContactFullName(){
        return contactFullName.getText();
    }

    @Step("Get Account Type")
    public String getContactAccountName(){
        return new AccountInfoParser(contactAccountName.getText()).getDisplayedText();
    }

    @Step("Get Account Phone")
    public String getContactTitle(){
        return new AccountInfoParser(contactTitle.getText()).getLinkText();
    }

    @Step("Get Account Website")
    public String getContactEmail(){
        return new AccountInfoParser(contactEmail.getText()).getLinkText();
    }

    @Step("Get Account Site")
    public String getContactPhone(){
        return new AccountInfoParser(contactPhone.getText()).getDisplayedText();
    }

}
