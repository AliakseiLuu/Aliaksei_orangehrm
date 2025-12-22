package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;

  // public LeftSideMenu leftSideMenu;

  // protected By leftSideMenu = By.xpath("//div/ul[@class='oxd-main-menu']");

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // this.leftSideMenu = new LeftSideMenu(driver, wait);
  }

  // Ожидание видимости элемента
  public WebElement waitForVisibility(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  // Ожидание кликабельности элемента
  public WebElement waitForClickable(By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  // Клик по элементу
  public void click(By locator) {
    waitForClickable(locator).click();
  }

  // Ввод текста
  public void enterValue(By locator, String text) {
    WebElement element = waitForVisibility(locator);
    element.clear(); // очищаем поле перед вводом
    element.sendKeys(text);
  }

  // Получение текста элемента
  public String getText(By locator) {
    return waitForVisibility(locator).getText();
  }

  // Проверка отображения элемента
  public boolean isDisplayed(By locator) {
    try {
      return waitForVisibility(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
