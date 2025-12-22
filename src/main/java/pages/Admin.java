package pages;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin extends BasePage {

  private final By searchButton = By.xpath("//button[text()=' Search ']");
  private final By usernameField =
      By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
  private final By userRoleField = By.xpath("//div[text()='-- Select --']");
  private final By employeeNameField =
      with(By.tagName("input")).below(By.xpath("//label[text()='Employee Name']"));
  private final By addButton = By.xpath("//button[text()=' Add ']");
  private final By addUserBlock = By.xpath("//div/div[@class='orangehrm-card-container']");
  private final By adminItemInUserRole =
      By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']");

  public Admin(WebDriver driver) {
    super(driver);
  }

  public Admin enterUserName(String name) {
    enterValue(usernameField, name);
    return this;
  }

  public Admin selectItemInUserRole() {
    click(userRoleField);
    click(adminItemInUserRole);
    return this;
  }

  public Admin enterEmployeeName(String name) {
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
}
