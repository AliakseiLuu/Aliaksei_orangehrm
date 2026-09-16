package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  private final WebDriver driver;
  private final WebDriverWait wait;
  private static final By SUCCESS_TOASTER = By.xpath("//div[contains(@class,'oxd-toast')]");
  private static final By SUCCESS_TOASTER_TEXT =
      By.xpath("//div[contains(@class,'oxd-toast')]//p[contains(@class,'oxd-toast-content-text')]");

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

  protected void click(final By locator) {
    waitForClickable(locator).click();
  }

  public void enterValue(final By locator, final String text) {
    WebElement element = waitForVisibility(locator);
    element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    element.sendKeys(text);

    if (!text.equals(element.getAttribute("value"))) {
      element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
      element.sendKeys(text);
    }
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

  public void selectFromDropdown(final By dropdownField, final String optionText) {
    waitForClickable(dropdownField);
    click(dropdownField);

    By option =
        By.xpath(
            "//div[@role='listbox' and not(contains(@style,'display: none'))]"
                + "//span[contains(normalize-space(),'"
                + optionText
                + "')]");
    waitForVisibility(option);
    click(option);
  }

  public boolean isSuccessToasterVisible() {
    try {
      waitForVisibility(SUCCESS_TOASTER);
      waitForVisibility(SUCCESS_TOASTER_TEXT);
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  public void selectFirstAutocompleteSuggestion(final By inputLocator, final String typedText) {
    WebElement input = waitForVisibility(inputLocator);
    input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    input.sendKeys(typedText);

    By noRecords = By.xpath("//div[@role='option'][normalize-space()='No Records Found']");
    By firstOption = By.xpath("//div[@role='option' and normalize-space()!='Searching....'][1]");

    try {
      waitForClickable(firstOption);
    } catch (TimeoutException e) {
      if (!getDriver().findElements(noRecords).isEmpty()) {
        throw new RuntimeException(
            "Autocomplete has no suggestions for query: '" + typedText + "'");
      }
      throw e;
    }
    click(firstOption);
  }

  protected void unfocus() {
    driver.findElement(By.tagName("body")).click();
  }
}
