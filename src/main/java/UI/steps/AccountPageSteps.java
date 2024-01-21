package UI.steps;

import UI.wrappers.Input;
import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

@Log4j2
public class AccountPageSteps extends BaseSteps {

    @Step("Create New Complete Account")
    public void createCompleteAccount(Account account){
        log.info("Creating account with complete data from model: " + account.getAccountName());
        accountsPage.clickNewAccountButton();
        accountsPage.enterCompleteData(account);
        accountsPage.clickSaveButton();
    }

    @Step("Create New Necessary Account")
    public void createEssentialAccount(Account account){
        log.info("Creating account with only essential fields from model: " + account.getAccountName());
        accountsPage.clickNewAccountButton();
        accountsPage.enterNecessaryData(account);
        accountsPage.clickSaveButton();
    }

    @Step("Create account without necessary fields")
    public void createEmptyAccount(){
        log.info("Creating account without any data inputted");
        accountsPage.clickNewAccountButton();
        accountsPage.clickSaveButton();
    }

    @Step("Check Account Exists")
    public boolean checkAccountTitleExists(){
        log.info("Checking Account Title Exists");
        return accountsPage.checkAccountTitleExists();
    }

    @Step("Read Account")
    public void readAccount(Account account){
        log.info("Openning account: " + account.getAccountName());
        accountsPage.openAccount(account.getAccountName());
    }

    @Step("Check Account Exists")
    public boolean checkAccountExists(Account account){
        log.info("Checking account exists: " + account.getAccountName());
        return accountsPage.checkAccountExists(account.getAccountName());
    }

    @Step("Check All Account Fields")
    public void checkAccountFields(Account account){
        log.info("Checking data fields of account: " + account.getAccountName());
        Assert.assertEquals(accountsPage.getAccountTitle(),account.getAccountName());
        Assert.assertEquals(accountsPage.getAccountType(),account.getType());
        Assert.assertEquals(accountsPage.getAccountPhone(),account.getPhone());
        Assert.assertEquals(accountsPage.getAccountWebsite(),account.getWebsite());
        Assert.assertEquals(accountsPage.getAccountIndustry(),account.getIndustry());
        Assert.assertEquals(accountsPage.getAccountSite(), account.getAccountSite());
    }

    @Step("Check Title Field")
    public void checkTitleField(Account account){
        log.info("Checking Title field for account: " + account.getAccountName());
        Assert.assertEquals(accountsPage.getAccountTitle(),account.getAccountName());
    }

    @Step("Check Account Creation Error Artifacts")
    public void checkErrorMessages(){
        log.info("Checking that Error Icon and Error Message exist");
        Assert.assertTrue(accountsPage.checkObligatoryErrorIconExists());
        Assert.assertTrue(accountsPage.checkObligatoryErrorMessageExists());
    }

    @Step("Close Create Account Window")
    public void closeCreateAccountWindow(){
        log.info("Closing Create Account window");
        accountsPage.clickCancelButton();
    }

    @Step("Edit existing account")
    public void editExistingAccount(Account account, String newName){
        log.info("Editing Account: " + account.getAccountName());
        accountsPage.clickEditButton(account);
        new Input("Account Name").edit(newName);
        accountsPage.clickSaveButton();
    }

    @Step("Delete existing account")
    public void deleteExistingAccount(Account account){
        log.info("Deleting Account: " + account.getAccountName());
        accountsPage.clickDeleteButton(account);
        accountsPage.confirmDeleteButton();
    }

}
