package UI;

import dto.AccountModel;
import dto.AccountModelBuilder;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class AccountsTest extends BaseTest {

    AccountModel completeAccount = AccountModelBuilder.getFullAccount();
    AccountModel essentialAccount = AccountModelBuilder.getEssentialAccount();
    AccountModel editedAccount = AccountModelBuilder.getEditedAccount();

    @BeforeMethod(description = "Login and switch to Accounts tab", alwaysRun = true)
    public void setUp(){
        log.info("Logging in and opening Accounts tab");
        loginPageSteps.loginToSite(validUser);
        navigationSteps.switchToServicesScreen();
        navigationSteps.switchToAccountsTab();
    }

    @Test(description = "Check Complete Account creation", groups = "Smoke")
    public void checkCreateFullAccount(){
        log.info("Test: create account with all data fields");
        accountPageSteps.createCompleteAccount(completeAccount);

        Assert.assertTrue(accountPageSteps.checkAccountTitleExists());
    }

    @Test(description = "Check Read Created Account", groups = "Smoke")
    public void checkReadAccount(){
        log.info("Test: read existing account, check main fields data correct");
        accountPageSteps.readAccount(completeAccount);

        accountPageSteps.checkAccountFields(completeAccount);
    }

    @Test(description = "Check Creation of empty account has errors", groups = "Regression")
    public void checkEmptyAccountCreation(){
        log.info("Test: create account with no data, check errors appear");
        accountPageSteps.createEmptyAccount();

        accountPageSteps.checkErrorMessages();

        accountPageSteps.closeCreateAccountWindow();
    }

    @Test(description = "Check Create Account with only essential fields", groups = "Smoke")
    public void checkCreateEssentialAccount(){
        log.info("Test: create account with only essential fields");
        accountPageSteps.createEssentialAccount(essentialAccount);

        accountPageSteps.checkTitleField(essentialAccount);
    }


    @Test(description = "Check Edit Account", groups = "Regression", priority = 1)
    public void checkEditAccount(){
        log.info("Test: edit existing account title");
        accountPageSteps.editExistingAccount(essentialAccount,editedAccount.getAccountName());
        Assert.assertTrue(accountPageSteps.checkAccountExists(editedAccount));
    }
    
    @Test(description = "Check Delete Complete Account", groups = "Regression",
            priority = 2)
    public void checkDeleteCompleteAccount(){
        log.info("Test: delete complete account");
        accountPageSteps.deleteExistingAccount(completeAccount);
        Assert.assertTrue(accountPageSteps.checkAccountExists(completeAccount));
    }

    @Test(description = "Check Delete Edited Account", groups = "Regression",
            priority = 2)
    public void checkDeleteEditedAccount(){
        log.info("Test: delete edited account");
        accountPageSteps.deleteExistingAccount(editedAccount);
        Assert.assertTrue(accountPageSteps.checkAccountExists(editedAccount));
    }

    @AfterMethod
    public void logout(){
        loginPageSteps.logout();
    }


}
