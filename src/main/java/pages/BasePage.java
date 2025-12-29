package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  private WebDriver driver;
  private WebDriverWait wait;

  public BasePage(final WebDriver driverParam) {
    this.driver = driverParam;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  protected WebDriver getDriver() {
    return driver;
  }

  protected WebDriverWait getWait() {
    return wait;
  }

  public final WebElement waitForVisibility(final By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public final WebElement waitForClickable(final By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public void click(final By locator) {
    waitForClickable(locator).click();
  }

  public void enterValue(final By locator, final String text) {
    WebElement element = waitForVisibility(locator);
    element.clear();
    element.sendKeys(text);
  }

  public String getText(final By locator) {
    return waitForVisibility(locator).getText();
  }

  public boolean isDisplayed(final By locator) {
    try {
      return waitForVisibility(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
