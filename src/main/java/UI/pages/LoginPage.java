package UI.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class LoginPage {

    SelenideElement loginInput = $x("//input[@type='email']");
    SelenideElement passwordInput = $x("//input[@type='password']");
    SelenideElement submitButton = $x("//input[@type='submit']");
    SelenideElement loginErrorMessage = $x("//*[contains(text(),'Please check your username')]");
    SelenideElement profileButton = $x("//button[contains(@class,'userProfile')]");
    SelenideElement logoutButton = $x("//a[text()='Log Out']");

    @Step("Set user email")
    public void setLogin(String email){
        loginInput.setValue(email);
        log.debug("Set user email: " + email);
    }

    @Step("Set user password")
    public void setPassword(String password){
        passwordInput.setValue(password);
        log.debug("Set user password");
    }

    @Step("Click Log in button")
    public void clickSubmit(){
        submitButton.click();
        log.debug("Logging in");
    }

    @Step("Check Profile button exists")
    public boolean checkProfileButtonExists(){
        boolean profileExists = profileButton.exists();
        log.debug("Profile button exists: " + profileExists);
        return profileExists;
    }

    @Step("Check Login Failed message exists")
    public boolean checkLoginFailedExists(){
        boolean loginErrorMessageExists = loginErrorMessage.exists();
        log.debug("Profile button exists: " + loginErrorMessageExists);
        return loginErrorMessageExists;
    }

    @Step("Click Profile Button")
    public void clickProfileButton(){
        profileButton.click();
        log.debug("Clicked Profile button");
    }

    @Step("Click Log out Button")
    public void clickLogoutButton(){
        logoutButton.click();
        log.debug("Clicked Profile button");
    }

}
