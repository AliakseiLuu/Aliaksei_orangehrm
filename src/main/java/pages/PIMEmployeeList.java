package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMEmployeeList extends BasePage {

  private final By addPimUserButton =
      By.cssSelector("div.orangehrm-header-container > button.oxd-button[type='button']");
  private final By jobTitleInput =
      By.xpath(
          "//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text-input')][1]");
  private final By searchButton =
      By.xpath("//form[.//label[text()='Job Title']]//button[@type='submit']");

  public PIMEmployeeList(final WebDriver driver) {
    super(driver);
  }

  public PIMAddEmployee clickAddButton() {
    click(addPimUserButton);
    return new PIMAddEmployee(getDriver());
  }

  public PIMViewPersonalDetails openSalesPersonalDetailPage(final String jobTitle) {
    By rowLocator =
        By.xpath(
            "//div/div[text()='"
                + jobTitle
                + "']/../..//button/i[@class='oxd-icon bi-pencil-fill']");
    click(rowLocator);
    return new PIMViewPersonalDetails(getDriver());
  }

  public PIMEmployeeList filteringEmployeeListByJobTitle(final String title) {
    waitForClickable(jobTitleInput);
    click(jobTitleInput);

    By option =
        By.xpath("//div[@role='listbox']//span[contains(normalize-space(),'" + title + "')]");
    waitForVisibility(option);
    click(option);

    return this;
  }

  public PIMEmployeeList search() {
    click(searchButton);
    return this;
  }
}
