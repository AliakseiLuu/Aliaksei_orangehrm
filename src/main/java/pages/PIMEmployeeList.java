package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMEmployeeList extends BasePage {

  public static final String PIM_EmployeeList_URL =
      "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
  private final By addPimUserButton = By.xpath("//button[text()=' Add ']");

  public PIMEmployeeList(WebDriver driver) {
    super(driver);
  }

  public PIMAddEmployee clickAddButton() {
    click(addPimUserButton);
    return new PIMAddEmployee(driver);
  }
}
