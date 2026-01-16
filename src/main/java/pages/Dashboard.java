package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard extends BasePage {

  private final By dashboardHeader = By.xpath("//span/h6");
  private final By timeAtWorkSheet =
      By.xpath(
          "//div[1]/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']");
  private final By myActionsSheet =
      By.xpath(
          "//div[2]/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']");
  private final By quickLaunchSheet =
      By.xpath(
          "//div[3]/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']");
  private final By buzzLatestPostsSheet =
      By.xpath(
          "//div[4]/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']");
  private final By employeesOnLeaveTodaySheet =
      By.xpath(
          "//div/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget emp-leave-chart']");
  private final By employeeDistributionBySubUnitSheet =
      By.xpath(
          "//div[6]/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']");
  private final By employeeDistributionByLocationSheet =
      By.xpath(
          "//div[7]/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']");

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
    return isDisplayed(dashboardHeader);
  }

  public boolean isTimeAtWorkSheetVisible() {
    return isDisplayed(timeAtWorkSheet);
  }

  public boolean isMyActionsSheetVisible() {
    return isDisplayed(myActionsSheet);
  }

  public boolean isQuickLaunchSheetVisible() {
    return isDisplayed(quickLaunchSheet);
  }

  public boolean isBuzzLatestPostsSheetVisible() {
    return isDisplayed(buzzLatestPostsSheet);
  }

  public boolean isEmployeesOnLeaveTodaySheetVisible() {
    return isDisplayed(employeesOnLeaveTodaySheet);
  }

  public boolean isEmployeeDistributionBySubUnitSheetVisible() {
    return isDisplayed(employeeDistributionBySubUnitSheet);
  }

  public boolean isEmployeeDistributionByLocationSheetVisible() {
    return isDisplayed(employeeDistributionByLocationSheet);
  }
}
