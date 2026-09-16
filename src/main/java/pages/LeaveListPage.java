package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeaveListPage extends BasePage {

  private final By assignLeaveButton =
      By.xpath(
          "//a[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Assign Leave']");

  public LeaveListPage(final WebDriver driverParam) {
    super(driverParam);
  }

  public LeaveAssignLeavePage openAssignLeave() {
    waitForClickable(assignLeaveButton);
    click(assignLeaveButton);
    return new LeaveAssignLeavePage(getDriver());
  }
}
