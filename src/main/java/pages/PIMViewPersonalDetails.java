package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMViewPersonalDetails extends BasePage {

  private final By personalDetailsBlock =
      By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']");
  private final By fullUserName = By.xpath("//div/h6[normalize-space(.)!='']");

  public PIMViewPersonalDetails(final WebDriver driver) {
    super(driver);
  }

  public PIMViewPersonalDetails displayingCreatedUserData() {
    waitForVisibility(personalDetailsBlock);
    waitForVisibility(fullUserName);
    return this;
  }
}
