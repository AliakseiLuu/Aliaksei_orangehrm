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

  // Ожидание видимости элемента
  public final WebElement waitForVisibility(final By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  // Ожидание кликабельности элемента
  public final WebElement waitForClickable(final By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  // Клик по элементу
  public void click(final By locator) {
    waitForClickable(locator).click();
  }

  // Ввод текста
  public void enterValue(final By locator, final String text) {
    WebElement element = waitForVisibility(locator);
    element.clear(); // очищаем поле перед вводом
    element.sendKeys(text);
  }

  // Получение текста элемента
  public String getText(final By locator) {
    return waitForVisibility(locator).getText();
  }

  // Проверка отображения элемента
  public boolean isDisplayed(final By locator) {
    try {
      return waitForVisibility(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
