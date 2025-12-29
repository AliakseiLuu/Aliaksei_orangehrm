package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMEmployeeList extends BasePage {

  private final By addPimUserButton =
      By.cssSelector("div.orangehrm-header-container > button.oxd-button[type='button']");

  public PIMEmployeeList(final WebDriver driver) {
    super(driver);
  }

  public PIMAddEmployee clickAddButton() {
    click(addPimUserButton);
    return new PIMAddEmployee(getDriver());
  }
}
