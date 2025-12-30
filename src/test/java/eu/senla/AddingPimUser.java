package eu.senla;

import entities.PIMUser;
import org.testng.Assert;
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
        PIMUser.builder()
            .firstName(faker.name().firstName())
            .middleName(faker.name().nameWithMiddle())
            .lastName(faker.name().lastName())
            .build();

    LoginPage loginPage = new LoginPage(driver);
    boolean success =
        loginPage
            .login(username, password)
            .waitForDashboardHeader()
            .getSidepanel()
            .openPIM()
            .clickAddButton()
            .fillForm(pimUser)
            .isSuccessSavingToasterVisible();

    Assert.assertTrue(success, "Pim user doesn't created");
  }
}
