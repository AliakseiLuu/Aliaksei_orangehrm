package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard extends BasePage {

  public static final String DASHBOARD_URL =
      "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
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

  public Sidepanel getLeftSideMenu() {
    return new Sidepanel(getDriver());
  }
}
