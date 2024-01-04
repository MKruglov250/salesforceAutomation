package UI;

import UI.steps.AccountPageSteps;
import UI.steps.ContactPageSteps;
import UI.steps.LoginPageSteps;
import UI.steps.NavigationSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dto.UserModel;
import dto.UserModelBuilder;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;

import utilities.RetryListener;
import utilities.OurListener;
import utilities.PropertyReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({OurListener.class, RetryListener.class})
@Log4j2
public class BaseTest {

    UserModel validUser = UserModelBuilder.getValidUser();
    UserModel badUser = UserModelBuilder.getIncorrectUser();

    LoginPageSteps loginPageSteps = new LoginPageSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    AccountPageSteps accountPageSteps = new AccountPageSteps();
    ContactPageSteps contactPageSteps = new ContactPageSteps();

    @Attachment
    @Step("Attach Properties to report")
    public static byte[] getFileBytes(String resourceName) throws IOException{
        log.info("Attaching Properties file");
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }

    @BeforeTest(alwaysRun = true, description = "Initialize Salesforce autotest framework")
    public void before() throws IOException {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true)
        );



        log.info("Starting configuring web driver");
        getFileBytes("config.properties");
        Configuration.baseUrl = PropertyReader.getProperty("Baseurl");
        Configuration.browser = PropertyReader.getBrowserProperty();
        Configuration.headless = Boolean.getBoolean(PropertyReader.getProperty("Headless"));
        open(".");
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
