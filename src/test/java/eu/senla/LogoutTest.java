package eu.senla;

import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

  String username = Config.get("app.username");
  String password = Config.get("app.password");

  @Test
  public void Logout() {

    LoginPage loginPage = new LoginPage(driver);

    loginPage.login(username, password).getTopbarHeader().logout();

    Assert.assertEquals(loginPage.getCurrentUrl(), Config.get("app.url"), "Ссылки не совпадают");
  }
}
