package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin extends BasePage {

  private final By searchButton = By.xpath("//div//button[@type='submit']");
  private final By usernameField =
      By.xpath("//label[@class='oxd-label']/parent::div/following-sibling::div/input");
  private final By userRoleField = By.cssSelector("div.oxd-select-text");
  private final By employeeNameField = By.cssSelector("div.oxd-autocomplete-text-input input");
  private final By addButton =
      By.cssSelector("div.orangehrm-header-container > button.oxd-button[type='button']");
  private final By addUserBlock = By.xpath("//div/div[@class='orangehrm-card-container']");
  private final By adminItemInUserRole = By.cssSelector("div.oxd-select-text + div>div>span");
  private final By jobDropdownfield =
      By.xpath("//ul/li[2]/span[@class='oxd-topbar-body-nav-tab-item']");
  private final By jobTitlesItemInJobDropdown =
      By.xpath("//ul/li/a[@class='oxd-topbar-body-nav-tab-link']");

  public Admin(final WebDriver driver) {
    super(driver);
  }

  public Admin enterUserName(final String name) {
    enterValue(usernameField, name);
    return this;
  }

  public Admin selectItemInUserRole() {
    click(userRoleField);
    click(adminItemInUserRole);
    return this;
  }

  public Admin enterEmployeeName(final String name) {
    enterValue(employeeNameField, name);
    return this;
  }

  public Admin searchEmployees() {
    click(searchButton);
    return this;
  }

  public Admin openAddingUserPage() {
    click(addButton);
    waitForVisibility(addUserBlock);
    return this;
  }

  public ViewJobTitleListPage openJobTitlesPage() {
    click(jobDropdownfield);
    click(jobTitlesItemInJobDropdown);
    return new ViewJobTitleListPage(getDriver());
  }
}
