package UI.pages.accounts;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class AccountsPage {

    SelenideElement newAccountButton = $x("//div[@title='New']/parent::a");
    SelenideElement editButton = $x("//a[@title='Edit']");
    SelenideElement deleteButton = $x("//a[@title='Delete']");
    SelenideElement confirmDeleteButton = $x("//button[@title='Delete']");

    @Step("Click New Account button")
    public void clickNewAccountButton(){
        log.info("Click New Account Button");
        newAccountButton.click();
    }

    @Step("Click New Account button")
    public void openAccount(String accountLabel){
        log.info("Opening account: " + accountLabel);
        SelenideElement account = $x(String.format("//a[@title='%s']",accountLabel));
        account.click();
    }

    @Step("Click Actions Menu button")
    public void clickActionsMenu(String accountLabel){
        SelenideElement actionsMenuButton = $x(String.format("//a[@title='%s']/ancestor::tr//a[@role='button']",accountLabel));
        log.info("Clicking Actions menu for Account: " + accountLabel);
        actionsMenuButton.click();
    }

    @Step("Click Edit button")
    public void clickEditButton(){
        log.info("Clicking Edit button");
        editButton.click();
    }

    @Step("Click Delete button")
    public void clickDeleteButton(){
        log.info("Clicking Delete button");
        deleteButton.click();
    }

    @Step("Confirm Delete button")
    public void confirmDeleteButton(){
        log.info("Confirming Deletion");
        confirmDeleteButton.click();
    }



}
