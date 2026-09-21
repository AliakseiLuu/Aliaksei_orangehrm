package core;

import java.util.Map;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieInjector {

  private CookieInjector() {}

  public static void inject(
      final WebDriver driver, final Map<String, String> cookies, final String domain) {
    driver.manage().deleteAllCookies();
    for (Map.Entry<String, String> e : cookies.entrySet()) {
      driver
          .manage()
          .addCookie(
              new Cookie.Builder(e.getKey(), e.getValue())
                  .path("/")
                  .domain(domain)
                  .isHttpOnly(true)
                  .isSecure(true)
                  .build());
    }
  }
}
