package eu.senla;

import config.Config;
import io.qameta.allure.*;
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
  @Epic("Header")
  @Feature("User functionality")
  @Story("Logout")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("AliakseiL")
  @Description("Проверка Logout юзера")
  @Parameters({"username", "password"})
  public void Logout() {

    LoginPage loginPage = new LoginPage(driver);
    Dashboard dashboard = loginPage.login(username, password);

    dashboard.getTopbarHeader().logout();

    Allure.step(
        "User successfully logout",
        () ->
            Assert.assertEquals(
                dashboard.getCurrentUrl(), Config.get("app.url"), "Ссылки не совпадают"));
  }
}
