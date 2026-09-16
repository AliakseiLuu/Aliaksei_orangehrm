package pages;

import entities.PersonalDetailBlock;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class PIMViewPersonalDetails extends BasePage {

  private final By personalDetailsBlock =
      By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']");
  private final By fullUserName = By.xpath("//div/h6[normalize-space(.)!='']");
  private final By firstNameField = By.name("firstName");
  private final By middleNameField = By.name("middleName");
  private final By lastNameField = By.name("lastName");
  private final By employeeIdField =
      By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
  private final By otherIdField =
      By.xpath("//label[text()='Other Id']/../following-sibling::div//input");
  private final By driversLicenseNumberField =
      By.xpath("//label[contains(text(),'License Number')]/../following-sibling::div//input");
  private final By licenseExpiryDateField =
      By.xpath(
          "//label[.='License Expiry Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
  private final By nationalityDropDownField =
      By.xpath(
          "//label[.='Nationality']/../following-sibling::div//div[@class='oxd-select-text-input']");
  private final By materialStatusDropDownField =
      By.xpath(
          "//label[.='Marital Status']/../following-sibling::div//div[@class='oxd-select-text-input']");
  private final By dateOfBirthField =
      By.xpath(
          "//label[.='Date of Birth']/../following-sibling::div//input[@class='oxd-input oxd-input--active']");
  private final By genderMaleRadioButton =
      By.xpath(
          "//label[contains(normalize-space(.),'Male')]//span[contains(@class,'oxd-radio-input')]");
  private final By genderFemaleRadioButton =
      By.xpath(
          "//label[contains(normalize-space(.),'Female')]//span[contains(@class,'oxd-radio-input')]");
  private final By saveButton =
      By.xpath(
          "//p/following-sibling::button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
  private final By jobDetails =
      By.xpath("//a[contains(@href,'/web/index.php/pim/viewJobDetails')]");

  public PIMViewPersonalDetails(final WebDriver driver) {
    super(driver);
  }

  public boolean isAllFeildsIsPresentInThePersonalDetailsBlock() {
    List<By> fields =
        List.of(
            personalDetailsBlock,
            fullUserName,
            firstNameField,
            middleNameField,
            lastNameField,
            employeeIdField,
            otherIdField,
            driversLicenseNumberField,
            licenseExpiryDateField,
            nationalityDropDownField,
            materialStatusDropDownField,
            dateOfBirthField,
            genderMaleRadioButton,
            genderFemaleRadioButton,
            saveButton);

    for (By field : fields) {
      try {
        waitForVisibility(field);
      } catch (TimeoutException e) {
        System.out.println("NOT VISIBLE: " + field);
        return false;
      }
    }
    return true;
  }

  public PIMViewPersonalDetails assertVisibleAllFieldsInThePersonalDetailsBlock() {
    if (!isAllFeildsIsPresentInThePersonalDetailsBlock()) {
      throw new AssertionError("Some fields doesn't display in the Presonal Details block");
    }
    return this;
  }

  public PIMViewPersonalDetails fillForm(final PersonalDetailBlock personalDetailBlock) {
    enterValue(firstNameField, personalDetailBlock.getFirstNameField());
    enterValue(middleNameField, personalDetailBlock.getMiddleNameField());
    enterValue(lastNameField, personalDetailBlock.getLastNameField());
    enterValue(employeeIdField, personalDetailBlock.getEmployeeIdField());
    enterValue(otherIdField, personalDetailBlock.getOtherIdField());
    enterValue(driversLicenseNumberField, personalDetailBlock.getDriversLicenseNumberField());
    enterValue(licenseExpiryDateField, personalDetailBlock.getLicenseExpiryDateField());
    selectFromDropdown(nationalityDropDownField, personalDetailBlock.getNationalityDropDownField());
    selectFromDropdown(
        materialStatusDropDownField, personalDetailBlock.getMaterialStatusDropDownField());
    enterValue(dateOfBirthField, personalDetailBlock.getDateOfBirthField());
    click(saveButton);
    return this;
  }

  public PIMViewJobDetails openJobDetails() {
    click(jobDetails);
    return new PIMViewJobDetails(getDriver());
  }
}
