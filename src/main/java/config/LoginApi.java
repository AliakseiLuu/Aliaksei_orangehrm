package config;

import core.CookieInjector;
import org.openqa.selenium.WebDriver;

public class LoginApi {

  private LoginApi() {}

  public static void login(final WebDriver driver) {
    driver.manage().deleteAllCookies();
    CookieInjector.inject(driver, AuthApi.getSessionCookies(), Config.get("app.domain"));
    driver.navigate().to(Config.get("dashboard.url"));
  }
}
