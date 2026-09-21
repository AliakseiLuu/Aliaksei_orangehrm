package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMViewJobDetails extends BasePage {

  private final By jobTitleDropdown =
      By.xpath(
          "//label[.='Job Title']/../following-sibling::div//div[@class='oxd-select-text-input']");
  private final By saveButton =
      By.xpath(
          "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

  public PIMViewJobDetails(final WebDriver driver) {
    super(driver);
  }

  public PIMViewJobDetails changeUserJobTitleToSales(final String option) {
    selectFromDropdown(jobTitleDropdown, option);
    click(saveButton);
    return this;
  }
}
