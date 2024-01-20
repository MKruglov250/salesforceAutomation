package UI.pages.accounts;

import UI.wrappers.AccountInfoParser;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class SingleAccountPage {

    protected SelenideElement accountTitle = $x("//slot[@name='primaryField']/descendant::lightning-formatted-text");
    protected SelenideElement accountType = $x("//p[text()='Type']");
    protected SelenideElement accountPhone = $x("//p[text()='Phone']");
    protected SelenideElement accountWebsite = $x("//p[text()='Website']");
    protected SelenideElement accountSite = $x("//p[text()='Account Site']");
    protected SelenideElement accountIndustry = $x("//p[text()='Industry']");

    @Step("Account Title Field Exists")
    public boolean checkAccountTitleExists(){
        log.debug("Checking Account Title Exists");
        return accountTitle.exists();
    }

    @Step("Get Account Title")
    public String getAccountTitle(){
        log.debug("Account title: " + accountTitle.getText());
        return accountTitle.getText();
    }

    @Step("Get Account Type")
    public String getAccountType(){
        String accType = new AccountInfoParser(accountType.getText()).getDisplayedText();
        log.debug("Account Type: " + accountType);
        return accType;
    }

    @Step("Get Account Phone")
    public String getAccountPhone(){
        String accPhone = new AccountInfoParser(accountPhone.getText()).getLinkText();
        log.debug("Account Phone: " + accPhone);
        return accPhone;
    }

    @Step("Get Account Website")
    public String getAccountWebsite(){
        String accWebsite = new AccountInfoParser(accountWebsite.getText()).getLinkText();
        log.debug("Account Website: " + accWebsite);
        return accWebsite;
    }

    @Step("Get Account Site")
    public String getAccountSite(){
        String accSite = new AccountInfoParser(accountSite.getText()).getDisplayedText();
        log.debug("Account Site: " + accSite);
        return accSite;
    }

    @Step("Get Account Industry")
    public String getAccountIndustry(){
        String accIndustry = new AccountInfoParser(accountIndustry.getText()).getDisplayedText();
        log.debug("Account Industry: " + accIndustry);
        return accIndustry;
    }

}
