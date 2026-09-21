package listener;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

public class LoggingListener implements ITestListener {
  private static final Logger LOG = LoggerFactory.getLogger(LoggingListener.class);

  @Override
  public void onTestStart(final ITestResult result) {
    LOG.info("=== START: {} ===", result.getMethod().getDescription());
  }

  @Override
  public void onTestSuccess(final ITestResult result) {
    LOG.info(
        "=== PASSED: {} ({}ms) ===",
        result.getName(),
        result.getEndMillis() - result.getStartMillis());
  }

  @Override
  public void onTestFailure(final ITestResult result) {
    LOG.error("=== FAILED: {} ===", result.getName(), result.getThrowable());
    WebDriver driver = DriverManager.getDriver();
    if (driver != null) {
      ScreenshotUtil.takeScreenshot(driver);
    } else {
      System.out.println("WebDriver is null. Screenshot not taken.");
    }
  }
}
