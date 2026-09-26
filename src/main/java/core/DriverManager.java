package core;

import config.Config;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  private static ThreadLocal<String> testName = new ThreadLocal<>();

  private DriverManager() {}

  public static WebDriver getDriver() {
    if (driver.get() == null) {
      switch (Config.get("browser").toLowerCase()) {
        case "chrome" -> driver.set(isSelenoid() ? createRemoteChrome() : new ChromeDriver());
        case "firefox" -> driver.set(isSelenoid() ? createRemoteFirefox() : new FirefoxDriver());
        default -> throw new IllegalStateException("Incorrect browser");
      }
    }
    return driver.get();
  }

  private static boolean isSelenoid() {
    return Boolean.parseBoolean(Config.get("selenoid.enabled"));
  }

  private static WebDriver createRemoteChrome() {
    ChromeOptions options = new ChromeOptions();
    options
        .addArguments("--incognito")
        .addArguments("--disable-dev-shm-usage")
        .addArguments("--no-sandbox");

    Map<String, Object> selenoid = new HashMap<>();
    selenoid.put("name", testName.get());
    selenoid.put("videoName", testName.get() + ".mp4");
    selenoid.put("sessionTimeout", "5m");
    selenoid.put("enableVNC", true);
    selenoid.put("enableVideo", true);
    options.setCapability("selenoid:options", selenoid);

    try {
      return new RemoteWebDriver(new URL(Config.get("selenoid.url")), options);
    } catch (MalformedURLException e) {
      throw new IllegalStateException("Invalid selenoid.url: " + Config.get("selenoid.url"), e);
    }
  }

  private static WebDriver createRemoteFirefox() {
    FirefoxOptions options = new FirefoxOptions();
    options
        .addArguments("--incognito")
        .addArguments("--disable-dev-shm-usage")
        .addArguments("--no-sandbox");

    Map<String, Object> selenoid = new HashMap<>();
    selenoid.put("name", testName.get());
    selenoid.put("videoName", testName.get() + ".mp4");
    selenoid.put("sessionTimeout", "55m");
    selenoid.put("enableVNC", true);
    selenoid.put("enableVideo", true);
    options.setCapability("selenoid:options", selenoid);

    try {
      return new RemoteWebDriver(new URL(Config.get("selenoid.url")), options);
    } catch (MalformedURLException e) {
      throw new IllegalStateException("Invalid selenoid.url: " + Config.get("selenoid.url"), e);
    }
  }

  public static void initDriver(final String methodName) {
    testName.set(methodName + "_" + System.currentTimeMillis());
    getDriver();
  }

  public static String getTestName() {
    return testName.get();
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
    testName.remove();
  }
}
