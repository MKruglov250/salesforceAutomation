package UI.steps;

public class NavigationSteps extends BaseSteps {

    public void switchToServicesScreen(){
        navigationPage.clickServicesMenuButton();
        navigationPage.clickServiceButton();
    }

    public void switchToAccountsTab(){
        navigationPage.switchToAccountsTab();
    }

    public void switchToContactsTab(){
        navigationPage.switchToContactsTab();
    }

}
