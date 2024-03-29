package UI.steps;

import dto.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginPageSteps extends BaseSteps {

    @Step("Login to site")
    public void loginToSite(User user){
        log.info("Logging in to site");
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickSubmit();
    }

    @Step("Login with fail check")
    public boolean checkLoginFail(){
        boolean loginFailed = loginPage.checkLoginFailedExists();
        log.info("Login failed: " + loginFailed);
        return loginFailed;
    }

    @Step("Logout")
    public void logout(){
        loginPage.clickProfileButton();
        loginPage.clickLogoutButton();
        log.info("Logged out");
    }
}
