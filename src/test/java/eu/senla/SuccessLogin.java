package eu.senla;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class SuccessLogin extends BaseTest {

  // Параметризованный тест с параметрами заданными через testng.xml файл
  @Test
  @Parameters({"username", "password"})
  public void testSuccessLogin(
      @Optional("Admin") String username, @Optional("admin123") String password) {

    LoginPage loginPage = new LoginPage(driver);

    loginPage
        .login(username, password)
        .assertDashboardHeaderIsDisplayed()
        .assertThatUrlAfterLoginIsCorrect()
        .getLeftSideMenu()
        .isLeftSideMenuVisible()
        .openAdmin()
        .enterUserName("Admin")
        .selectItemInUserRole()
        .enterEmployeeName("vasia")
        .searchEmployees();
  }
}
