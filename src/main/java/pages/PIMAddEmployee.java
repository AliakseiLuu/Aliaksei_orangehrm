package pages;

import entities.PIMUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMAddEmployee extends BasePage {

  private final By firstNameField = By.name("firstName");
  private final By middleNameField = By.name("middleName");
  private final By lastNameField = By.name("lastName");
  private final By saveButton =
      By.xpath(
          "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
  private final By successSavingToaster = By.xpath("//div/div[contains(@class,'oxd-toast')]");
  private final By successTextInToaster = By.xpath("//div/p[text()='Success']");
  private final By employeeIdField =
      By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");

  public PIMAddEmployee(final WebDriver driver) {
    super(driver);
  }

  public PIMAddEmployee fillForm(final PIMUser pimUser) {
    enterValue(firstNameField, pimUser.getFirstName());
    enterValue(middleNameField, pimUser.getMiddleName());
    enterValue(lastNameField, pimUser.getLastName());
    enterValue(employeeIdField, pimUser.getEmployeeId());
    click(saveButton);
    return this;
  }

  public PIMViewPersonalDetails successUserCreation() {
    waitForVisibility(successSavingToaster);
    waitForVisibility(successTextInToaster);
    return new PIMViewPersonalDetails(getDriver());
  }
}
