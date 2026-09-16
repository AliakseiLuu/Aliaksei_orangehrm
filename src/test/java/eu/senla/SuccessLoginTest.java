package eu.senla;

import config.Config;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class SuccessLoginTest extends BaseTest {

  @BeforeClass
  public void forceUiLogin() {
    System.setProperty("login.type", "ui");
    autoLogin = false;
  }

  @Test
  @Parameters({"username", "password"})
  public void testSuccessLogin(
      @Optional("Admin") String username, @Optional("admin123") String password) {

    LoginPage loginPage = new LoginPage(driver);

    Dashboard dashboard = loginPage.login(username, password);

    Assert.assertTrue(dashboard.isDashboardHeaderDisplayed(), "Dashboard header is not displayed");
    Assert.assertEquals(
        dashboard.getCurrentUrl(), Config.get("dashboard.url"), "Ссылки не совпадают");

    dashboard
        .getSidepanel()
        .getSidepanel()
        .openAdmin()
        .enterUserName("Admin")
        .selectItemInUserRole()
        .enterEmployeeName("vasia")
        .searchEmployees();
  }

  @AfterClass
  public void restoreLoginType() {
    System.clearProperty("login.type");
  }
}
