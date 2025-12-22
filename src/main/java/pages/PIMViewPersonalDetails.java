package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMViewPersonalDetails extends BasePage {

  private final By personalDetailsBlock = By.xpath("//div/h6[text()='Personal Details']");
  private final By fullUserName = By.xpath("//div/h6[normalize-space(.)!='']");

  public PIMViewPersonalDetails(WebDriver driver) {
    super(driver);
  }

  public PIMViewPersonalDetails displayingCreatedUserData() {
    waitForVisibility(personalDetailsBlock);
    waitForVisibility(fullUserName);
    return this;
  }
}
