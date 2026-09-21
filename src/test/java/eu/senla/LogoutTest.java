package eu.senla;

import config.Config;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

  @BeforeClass
  public void forceUiLogin() {
    System.setProperty("login.type", "ui");
    autoLogin = false;
  }

  @Test
  @Parameters({"username", "password"})
  public void Logout() {

    LoginPage loginPage = new LoginPage(driver);
    Dashboard dashboard = loginPage.login(username, password);

    dashboard.getTopbarHeader().logout();

    Assert.assertEquals(dashboard.getCurrentUrl(), Config.get("app.url"), "Ссылки не совпадают");
  }
}
