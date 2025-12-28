package eu.senla;

import config.Config;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class SuccessLogin extends BaseTest {

  @Test
  @Parameters({"username", "password"})
  public void testSuccessLogin(
      @Optional("Admin") String username, @Optional("admin123") String password) {

    LoginPage loginPage = new LoginPage(driver);

    Dashboard dashboard = loginPage.login(username, password);

    Assert.assertTrue(dashboard.isDashboardHeaderDisplayed(), "Dashboard header is not displayed");
    Assert.assertEquals(dashboard.getCurrentUrl(), Config.get("dashboard.url"), "Ссылки не совпадают");

    dashboard
        .getLeftSideMenu()
        .isSidepanelVisible()
        .openAdmin()
        .enterUserName("Admin")
        .selectItemInUserRole()
        .enterEmployeeName("vasia")
        .searchEmployees();
  }
}
