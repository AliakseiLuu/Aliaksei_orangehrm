package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class Dashboard extends BasePage {

  private final By dashboardHeader = By.xpath("//span/h6");

  public Dashboard(final WebDriver driver) {
    super(driver);
  }

  public Dashboard waitForDashboardHeader() {
    waitForVisibility(dashboardHeader);
    return this;
  }

  public boolean isDashboardHeaderDisplayed() {
    return isDisplayed(dashboardHeader);
  }

  public String getCurrentUrl() {
    return getDriver().getCurrentUrl();
  }

  public Sidepanel getSidepanel() {
    return new Sidepanel(getDriver());
  }

  public TopbarHeader getTopbarHeader() {
    return new TopbarHeader(getDriver());
  }

  public boolean isHeaderVisible() {
    try {
      waitForVisibility(dashboardHeader);
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }
}
