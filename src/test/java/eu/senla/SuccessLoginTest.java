package eu.senla;

import config.Config;
import io.qameta.allure.*;
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
  @Epic("Login")
  @Feature("Login page")
  @Story("Success login")
  @Severity(SeverityLevel.BLOCKER)
  @Owner("AliakseiL")
  @Description("Тест успешного логина юзера")
  @Parameters({"username", "password"})
  public void testSuccessLogin(
      @Optional("Admin") String username, @Optional("admin123") String password) {

    LoginPage loginPage = new LoginPage(driver);
    Dashboard dashboard = loginPage.login(username, password);

    Allure.step(
        "Check that usser successfully logged in",
        () -> {
          Assert.assertTrue(
              dashboard.isDashboardHeaderDisplayed(), "Dashboard header is not displayed");
          Assert.assertEquals(
              dashboard.getCurrentUrl(), Config.get("dashboard.url"), "Ссылки не совпадают");
        });
  }

  @AfterClass
  public void restoreLoginType() {
    System.clearProperty("login.type");
  }
}
