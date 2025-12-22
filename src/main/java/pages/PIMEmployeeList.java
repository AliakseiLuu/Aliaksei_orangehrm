package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMEmployeeList extends BasePage {

  private final By addPimUserButton = By.xpath("//button[text()=' Add ']");

  public PIMEmployeeList(final WebDriver driver) {
    super(driver);
  }

  public PIMAddEmployee clickAddButton() {
    click(addPimUserButton);
    return new PIMAddEmployee(getDriver());
  }
}
