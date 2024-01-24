package UI.steps;

import UI.pages.LoginPage;
import UI.pages.NavigationPage;
import UI.pages.accounts.AccountsPage;
import UI.pages.accounts.CreateNewAccountPage;

public class BaseSteps {
    protected LoginPage loginPage = new LoginPage();
    protected NavigationPage navigationPage = new NavigationPage();
    protected AccountsPage accountsPage = new AccountsPage();
}
