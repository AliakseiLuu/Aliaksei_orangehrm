package eu.senla;

import entities.PIMUser;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddingPimUser extends BaseTest {

  @Test
  @Parameters({"username", "password"})
  public void testSuccessAddPIM_Employee(
      @Optional("Admin") String username, @Optional("admin123") String password) {

    PIMUser pimUser =
        PIMUser.builder().firstName("Aliaksei").middleName("Ivanovich").lastName("Ivanov").build();

    LoginPage loginPage = new LoginPage(driver);
    loginPage
        .login(username, password)
        .waitForDashboardHeader()
        .getLeftSideMenu()
        .openPIM()
        .clickAddButton()
        .fillForm(pimUser)
        .successUserCreation()
        .displayingCreatedUserData();
  }
}
