package UI.steps;

import UI.pages.LoginPage;
import UI.pages.NavigationPage;
import UI.pages.accounts.AccountsPage;
import UI.pages.accounts.CreateNewAccountPage;

public class BaseSteps {
    LoginPage loginPage = new LoginPage();
    NavigationPage navigationPage = new NavigationPage();
    AccountsPage accountsPage = new AccountsPage();
    CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();
}
