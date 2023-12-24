package UI.pages.accounts;

import UI.wrappers.AccountInfoParser;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SingleAccountPage {

    SelenideElement accountTitle = $x("//slot[@name='primaryField']/descendant::lightning-formatted-text");
    SelenideElement accountType = $x("//p[text()='Type']");
    SelenideElement accountPhone = $x("//p[text()='Phone']");
    SelenideElement accountWebsite = $x("//p[text()='Website']");
    SelenideElement accountSite = $x("//p[text()='Account Site']");
    SelenideElement accountIndustry = $x("//p[text()='Industry']");

    @Step("Account Title Field Exists")
    public boolean checkAccountTitleExists(){
        return accountTitle.exists();
    }

    @Step("Get Account Title")
    public String getAccountTitle(){
        return accountTitle.getText();
    }

    @Step("Get Account Type")
    public String getAccountType(){
        return new AccountInfoParser(accountType.getText()).getDisplayedText();
    }

    @Step("Get Account Phone")
    public String getAccountPhone(){
        return new AccountInfoParser(accountPhone.getText()).getLinkText();
    }

    @Step("Get Account Website")
    public String getAccountWebsite(){
        return new AccountInfoParser(accountWebsite.getText()).getLinkText();
    }

    @Step("Get Account Site")
    public String getAccountSite(){
        return new AccountInfoParser(accountSite.getText()).getDisplayedText();
    }

    @Step("Get Account Industry")
    public String getAccountIndustry(){
        return new AccountInfoParser(accountIndustry.getText()).getDisplayedText();
    }

}
