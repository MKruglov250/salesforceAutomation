package UI;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginTest extends BaseTest{

    public LoginTest() throws FileNotFoundException {
    }

    @BeforeMethod(description = "Open Login page", alwaysRun = true)
    public void openLoginPage(){
        open("https://login.salesforce.com/");
    }


    @Test(description = "Login with incorrect credentials", groups = "Smoke")
    public void testLoginBadUser(){
        log.info("Testing login with Invalid credentials");
        loginPageSteps.loginToSite(badUser);
        Assert.assertTrue(loginPageSteps.checkLoginFail());
    }

}
