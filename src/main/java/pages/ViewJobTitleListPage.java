package pages;

import io.qameta.allure.Step;
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

  @Step("Go to the page Add job title page")
  public AddJobTitlePage openAddJobTitlesPage() {
    click(addButton);
    return new AddJobTitlePage(getDriver());
  }

  @Step("Delete job title")
  public ViewJobTitleListPage deleteJobTitle(final String jobTitle) {
    By rowLocator =
        By.xpath(
            "//div/div[text()='" + jobTitle + "']/../..//button/i[@class='oxd-icon bi-trash']");
    click(rowLocator);
    return this;
  }

  @Step("Agree with job title deletion")
  public ViewJobTitleListPage agreeWithDelitingJobTitle() {
    click(yesDeleteButtonInModalWindow);
    return this;
  }
}
