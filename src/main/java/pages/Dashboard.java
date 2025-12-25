package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Dashboard extends BasePage {

  public static final String DASHBOARD_URL =
      "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
  private final By dashboardHeader = By.xpath("//span/h6");

  public Dashboard(final WebDriver driver) {
    super(driver);
  }

  public Dashboard assertDashboardHeaderIsDisplayed() {
    Assert.assertTrue(isDisplayed(dashboardHeader), "Dashboard header is not displayed");
    return this;
  }

  public Dashboard assertThatUrlAfterLoginIsCorrect() {
    Assert.assertEquals(getDriver().getCurrentUrl(), DASHBOARD_URL, "Ссылки не совпадают");
    return this;
  }

  public Sidepanel getLeftSideMenu() {
    return new Sidepanel(getDriver());
  }
}
