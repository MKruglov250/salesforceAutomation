package Cucumber.steps;

import UI.steps.AccountPageSteps;
import UI.steps.LoginPageSteps;
import UI.steps.NavigationSteps;
import com.codeborne.selenide.Configuration;
import dto.AccountModel;
import dto.AccountModelBuilder;
import dto.UserModel;
import dto.UserModelBuilder;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import utilities.PropertyReader;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class createAccountSteps {

    UserModel validUser = UserModelBuilder.getValidUser();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    AccountPageSteps accountPageSteps = new AccountPageSteps();
    static AccountModel essentialAccount;

    @Before
    public void setUp() throws FileNotFoundException {
        Configuration.baseUrl = PropertyReader.getProperty("Baseurl");
        Configuration.browser = PropertyReader.getProperty("Browser");
        open(".");
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().implicitlyWait(Duration
                .ofSeconds(PropertyReader.getTimeoutProperty()));
    }
    @Given("User logs in")
    public void userLogsIn() {
        log.info("Logging in");
        loginPageSteps.loginToSite(validUser);
    }

    @When("User Opens Account page")
    public void userOpensAccountPage() {
        log.info("Opening Accounts tab");
        navigationSteps.switchToServicesScreen();
        navigationSteps.switchToAccountsTab();
    }

    @When("User Creates Account John Frost")
    public void userCreatesAccountAccountName() {
        essentialAccount = AccountModelBuilder.getEssentialAccount();
        log.info("Creating account with name: " + essentialAccount.getAccountName());
        accountPageSteps.createEssentialAccount(essentialAccount);
    }

    @Then("Account Title is John Frost")
    public void accountTitleIsJohnFrost() {
        log.info("Checking that account name is: " + essentialAccount.getAccountName());
        accountPageSteps.checkTitleField(essentialAccount);
        loginPageSteps.logout();
    }

//    @After("Logout")
//    public void logout(){
//        loginPageSteps.logout();
//    }
}
