package UI;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {

    @BeforeMethod(description = "Login and switch to Accounts tab", alwaysRun = true)
    public void setUp(){
        loginPageSteps.loginToSite(validUser);
        navigationSteps.switchToServicesScreen();
        navigationSteps.switchToAccountsTab();
    }

    @Test(description = "Check Complete Account creation", groups = "Smoke")
    public void checkCreateCompleteAccount(){
        accountPageSteps.createCompleteAccount(accountModel);
        Assert.assertTrue(accountPageSteps.checkAccountExists());
    }

    @Test(description = "Check Read Created Account")
    public void checkReadAccount(){
        accountPageSteps.readAccount(accountModel);

        accountPageSteps.checkAccountFields(accountModel);
    }

    @AfterMethod
    public void logout(){
        loginPageSteps.logout();
    }


}
