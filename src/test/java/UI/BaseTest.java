package UI;

import UI.steps.AccountPageSteps;
import UI.steps.ContactPageSteps;
import UI.steps.LoginPageSteps;
import UI.steps.NavigationSteps;
import com.codeborne.selenide.Configuration;
import dto.User;
import dto.UserBuilder;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;

import utilities.RetryListener;
import utilities.OurListener;
import utilities.PropertyReader;
import utilities.SetupCleanupUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({OurListener.class, RetryListener.class})
@Log4j2
public class BaseTest {

    protected User validUser = UserBuilder.getValidUser();
    protected User badUser = UserBuilder.getIncorrectUser();

    protected LoginPageSteps loginPageSteps = new LoginPageSteps();
    protected NavigationSteps navigationSteps = new NavigationSteps();
    protected AccountPageSteps accountPageSteps = new AccountPageSteps();
    protected ContactPageSteps contactPageSteps = new ContactPageSteps();

    @Attachment
    @Step("Attach Properties to report")
    public static byte[] getFileBytes(String resourceName) throws IOException{
        log.info("Attaching Properties file");
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }

    @BeforeSuite(description = "Create Test Data")
    public void setUpClass(){
        SetupCleanupUtils.deleteRecentAccounts();
        SetupCleanupUtils.deleteRecentContacts();

        SetupCleanupUtils.createTestAccounts();
        SetupCleanupUtils.createJohnDoeAccount();
        SetupCleanupUtils.createTestContacts();
    }

    @AfterSuite(description = "Cleanup Test Data")
    public void cleanUp(){
        SetupCleanupUtils.deleteRecentAccounts();
        SetupCleanupUtils.deleteRecentContacts();
    }

    @BeforeTest(alwaysRun = true, description = "Initialize Salesforce autotest framework")
    public void before() throws IOException {

        log.info("Starting configuring web driver");
        getFileBytes("config.properties");
        Configuration.baseUrl = PropertyReader.getProperty("Baseurl");
        Configuration.browser = Optional.ofNullable(System.getProperty("browser"))
                .orElse(PropertyReader.getBrowserProperty());
        log.info("Set browser to: " + System.getProperty("browser"));
        Configuration.headless = Boolean.getBoolean(PropertyReader.getProperty("Headless"));
        log.info("Opening WebDriver");
        open(".");
        log.info("WebDriver Opened");
        Configuration.screenshots = true;

        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().implicitlyWait(Duration
                .ofSeconds(PropertyReader.getTimeoutProperty()));

        log.info("Web driver configuration complete");
    }

    @AfterTest(description = "Closing web drivers", alwaysRun = true)
    public void afterTest() {
        closeWebDriver();
    }
}
