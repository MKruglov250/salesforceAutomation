package UI.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class NavigationPage {

    protected SelenideElement servicesMenuButton = $x("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]");
    protected SelenideElement serviceButton = $x("//a[@data-label='Service']/parent::*");
    protected SelenideElement accountsTab = $x("//a[@title='Accounts']/parent::*");
    protected SelenideElement contactsTab = $x("//a[@title='Contacts']/parent::*");
    protected SelenideElement casesTab = $x("//a[@title='Cases']/parent::*");

    public void clickServicesMenuButton(){
        log.debug("Pressing Services Menu Button");
        servicesMenuButton.click();
    }

    public void clickServiceButton(){
        log.debug("Pressing Service Button");
        serviceButton.click();
    }

    public void switchToAccountsTab(){
        log.debug("Switcing to Accounts tab");
        accountsTab.click();
    }

    public void switchToContactsTab(){
        log.debug("Switcing to Contacts tab");
        contactsTab.click();
    }

    public void switchToCasesTab(){
        log.debug("Switcing to Accounts tab");
        casesTab.click();
    }

}
