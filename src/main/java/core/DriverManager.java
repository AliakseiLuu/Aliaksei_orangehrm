package core;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  private DriverManager() {}

  public static WebDriver getDriver() {
    if (driver.get() == null) {
      switch (Config.get("browser").toLowerCase()) {
        case "chrome" -> driver.set(new ChromeDriver());
        case "firefox" -> driver.set(new FirefoxDriver());
        default -> throw new IllegalStateException("Incorrect browser");
      }
    }
    return driver.get();
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
