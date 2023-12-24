package UI.steps;

import dto.AccountModel;
import io.qameta.allure.Step;
import org.testng.Assert;

public class AccountPageSteps extends BaseSteps {

    @Step("Create New Complete Account")
    public void createCompleteAccount(AccountModel accountModel){
        accountsPage.clickNewAccountButton();
        accountsPage.enterCompleteData(accountModel);
        accountsPage.clickSaveButton();
    }

    @Step("Create New Necessary Account")
    public void createNecessaryAccount(AccountModel accountModel){
        accountsPage.clickNewAccountButton();
        accountsPage.enterNecessaryData(accountModel);
        accountsPage.clickSaveButton();
    }

    @Step("Create account without necessary fields")
    public void createEmptyAccount(){
        accountsPage.clickNewAccountButton();
        accountsPage.clickSaveButton();
    }

    @Step("Check Account Exists")
    public boolean checkAccountExists(){
        return accountsPage.checkAccountTitleExists();
    }

    @Step("Read Account")
    public void readAccount(AccountModel account){
        accountsPage.openAccount(account.getAccountName());
    }

    @Step("Check All Account Fields")
    public void checkAccountFields(AccountModel account){
        Assert.assertEquals(accountsPage.getAccountTitle(),account.getAccountName());
        Assert.assertEquals(accountsPage.getAccountType(),account.getType());
        Assert.assertEquals(accountsPage.getAccountPhone(),account.getPhone());
        Assert.assertEquals(accountsPage.getAccountWebsite(),account.getWebsite());
        Assert.assertEquals(accountsPage.getAccountIndustry(),account.getIndustry());
        Assert.assertEquals(accountsPage.getAccountSite(), account.getAccountSite());
    }

    @Step("Check Title Field")
    public void checkTitleField(AccountModel account){
        Assert.assertEquals(accountsPage.getAccountTitle(),account.getAccountName());
    }

    @Step("Check Account Creation Error Artifacts")
    public void checkErrorMessages(AccountModel accountModel){
        Assert.assertTrue(accountsPage.checkObligatoryErrorIconExists());
        Assert.assertTrue(accountsPage.checkObligatoryErrorMessageExists());
    }

}
