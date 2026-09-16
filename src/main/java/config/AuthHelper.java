package config;

import org.openqa.selenium.WebDriver;
import pages.Dashboard;
import pages.LoginPage;

public class AuthHelper {

  private AuthHelper() {}

  public static void login(final WebDriver driver, final String username, final String password) {
    String type = Config.get("login.type");

    if ("api".equalsIgnoreCase(type)) {
      driver.get("https://" + Config.get("app.domain"));
      LoginApi.login(driver);
    } else {
      new LoginPage(driver).login(username, password);
    }

    new Dashboard(driver).waitForDashboardHeader();
  }
}
