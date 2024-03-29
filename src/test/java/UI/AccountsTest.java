package UI;

import com.codeborne.selenide.Selenide;
import dto.Account;
import dto.AccountBuilder;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

@Log4j2
public class AccountsTest extends BaseTest {

    private Account completeAccount = AccountBuilder.getFullAccount();
    private Account essentialAccount = AccountBuilder.getEssentialAccount();
    private Account toEditAccount = AccountBuilder.getEssentialAccount("NOT YET EDITED");
    private Account editedAccount = AccountBuilder.getEssentialAccount("Edited Account");
    private Account toDeleteAccount = AccountBuilder.getEssentialAccount("TO DELETE");

    public AccountsTest() throws FileNotFoundException {
    }

    @BeforeMethod(description = "Login and switch to Accounts tab", alwaysRun = true)
    public void setUpTest(){
        log.info("Logging in and opening Accounts tab");
        loginPageSteps.loginToSite(validUser);
        navigationSteps.switchToServicesScreen();
        navigationSteps.switchToAccountsTab();
    }

    @AfterMethod
    public void logout(){
        loginPageSteps.logout();
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
        accountPageSteps.editExistingAccount(toEditAccount,editedAccount.getAccountName());
        Assert.assertTrue(accountPageSteps.checkAccountExists(editedAccount));
    }

    @Test(description = "Check Account Deletion", groups = "Regression", priority = 2)
    public void checkDeleteAccount(){
        log.info("Test: delete existing test account");
        accountPageSteps.deleteExistingAccount(toDeleteAccount);
        Selenide.refresh();
        Assert.assertFalse(accountPageSteps.checkAccountExists(toDeleteAccount));
    }


}
