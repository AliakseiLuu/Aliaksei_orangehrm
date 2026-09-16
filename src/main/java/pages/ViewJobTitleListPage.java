package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewJobTitleListPage extends BasePage {

  private final By addButton =
      By.xpath("//div/button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
  private final By yesDeleteButtonInModalWindow =
      By.xpath("//button/i[@class='oxd-icon bi-trash oxd-button-icon']");

  public ViewJobTitleListPage(final WebDriver driverParam) {
    super(driverParam);
  }

  public AddJobTitlePage openAddJobTitlesPage() {
    click(addButton);
    return new AddJobTitlePage(getDriver());
  }

  public ViewJobTitleListPage deleteJobTitle(final String jobTitle) {
    By rowLocator =
        By.xpath(
            "//div/div[text()='" + jobTitle + "']/../..//button/i[@class='oxd-icon bi-trash']");
    click(rowLocator);
    return this;
  }

  public ViewJobTitleListPage agreeWithDelitingJobTitle() {
    click(yesDeleteButtonInModalWindow);
    return this;
  }
}
