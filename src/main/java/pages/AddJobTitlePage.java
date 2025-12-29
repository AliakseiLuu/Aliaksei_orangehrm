package pages;

import entities.Job;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class AddJobTitlePage extends BasePage {

  private final By jobTitleField =
      By.cssSelector("div.oxd-input-group input.oxd-input");
  private final By jobDescriptionField =
      By.xpath("//div/textarea[@placeholder='Type description here']");
  private final By jobAddNoteField = By.xpath("//div/textarea[@placeholder='Add note']");
  private final By saveButton =
      By.xpath(
          "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
  private final By successSavingToaster = By.xpath("//div/div[contains(@class,'oxd-toast')]");
  private final By successTextInToaster = By.xpath("//div/p[text()='Success']");

  public AddJobTitlePage(final WebDriver driverParam) {
    super(driverParam);
  }

  public AddJobTitlePage fillForm(final Job job) {
    enterValue(jobTitleField, job.getJobTitleField());
    enterValue(jobDescriptionField, job.getJobDescriptionField());
    enterValue(jobAddNoteField, job.getJobAddNoteField());
    click(saveButton);
    return this;
  }

  public boolean isSuccessSavingToasterVisible() {
    try {
      waitForVisibility(successSavingToaster);
      waitForVisibility(successTextInToaster);
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }
}
