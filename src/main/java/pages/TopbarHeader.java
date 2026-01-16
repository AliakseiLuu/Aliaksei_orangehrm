package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopbarHeader extends BasePage {

  private final By userdropdown = By.xpath("//li/span[@class='oxd-userdropdown-tab']");
  private final By logoutItemInuserdropdown = By.xpath("//a[@href='/web/index.php/auth/logout']");

  public TopbarHeader(final WebDriver driverParam) {
    super(driverParam);
  }

  public void logout() {
    waitForVisibility(userdropdown).click();
    waitForVisibility(logoutItemInuserdropdown).click();
  }
}
