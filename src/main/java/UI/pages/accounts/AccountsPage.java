package UI.pages.accounts;

import com.codeborne.selenide.SelenideElement;
import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class AccountsPage extends CreateNewAccountPage{

    private SelenideElement newAccountButton = $x("//div[@title='New']/parent::a");
    private SelenideElement editButton = $x("//a[@title='Edit']");
    private SelenideElement deleteButton = $x("//a[@title='Delete']");
    private SelenideElement confirmDeleteButton = $x("//button[@title='Delete']");

    @Step("Click New Account button")
    public void clickNewAccountButton(){
        log.info("Click New Account Button");
        newAccountButton.click();
    }

    @Step("Open Account")
    public void openAccount(String accountLabel){
        log.info("Opening account: " + accountLabel);
        SelenideElement account = $x(String.format("//a[@title='%s']",accountLabel));
        account.should(exist);
        account.click();
    }

    @Step("Check account exists on page")
    public boolean checkAccountExists(String accountLabel){
        log.info("Checking account exists on page: " + accountLabel);
        boolean accountExists = $x(String.format("//a[@title='%s']",accountLabel)).exists();
        log.info("Account exists: " + accountExists);
        return accountExists;
    }


    @Step("Click Edit button")
    public void clickEditButton(Account account){
        log.info("Clicking Edit button for account: " + account.getAccountName());
        $x(String.format("//a[text()='%s']/ancestor::tr//a[@role='button']/ancestor::span",
                account.getAccountName())).click();
        editButton.click();
    }

    @Step("Click Delete button")
    public void clickDeleteButton(Account account){
        log.info("Clicking Delete button for account: " + account.getAccountName());
        $x(String.format("//a[text()='%s']/ancestor::tr//a[@role='button']/ancestor::span",
                account.getAccountName())).click();
        deleteButton.click();
    }

    @Step("Confirm Delete button")
    public void confirmDeleteButton(){
        log.info("Confirming Deletion");
        confirmDeleteButton.click();
    }



}
