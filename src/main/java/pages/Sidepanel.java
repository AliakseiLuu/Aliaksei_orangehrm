package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sidepanel extends BasePage {

  private final By sidepanel = By.xpath("//div/ul[@class='oxd-main-menu']");
  private final By dashboard = By.xpath("//a[@href='/web/index.php/dashboard/index']");
  private final By pim = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
  private final By admin = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");

  public Sidepanel(final WebDriver driver) {
    super(driver);
  }

  public Sidepanel getSidepanel() {
    waitForVisibility(sidepanel);
    return this;
  }

  public Admin openAdmin() {
    waitForVisibility(admin).click();
    return new Admin(getDriver());
  }

  public PIMEmployeeList openPIM() {
    waitForVisibility(pim).click();
    return new PIMEmployeeList(getDriver());
  }

  public Dashboard openDashboard() {
    waitForVisibility(dashboard).click();
    return new Dashboard(getDriver());
  }

  public boolean isSidepanelVisible() {
    waitForVisibility(sidepanel);
    return true;
  }
}
