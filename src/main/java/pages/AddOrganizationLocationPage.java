package pages;

import entities.OrganizationLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOrganizationLocationPage extends BasePage {

  private static final By NAME_FIELD =
      By.xpath("//label[normalize-space()='Name']/../following-sibling::div//input");
  private static final By CITY_FIELD =
      By.xpath("//label[normalize-space()='City']/../following-sibling::div//input");
  private static final By STATE_PROVINCE_FIELD =
      By.xpath("//label[normalize-space()='State/Province']/../following-sibling::div//input");
  private static final By ZIP_POSTAL_CODE_FIELD =
      By.xpath("//label[normalize-space()='Zip/Postal Code']/../following-sibling::div//input");
  private static final By COUNTRY_DROPDOWN =
      By.xpath(
          "//label[normalize-space()='Country']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
  private static final By PHONE_FIELD =
      By.xpath("//label[normalize-space()='Phone']/../following-sibling::div//input");
  private static final By FAX_FIELD =
      By.xpath("//label[normalize-space()='Fax']/../following-sibling::div//input");
  private static final By ADDRESS_FIELD =
      By.xpath("//label[normalize-space()='Address']/../following-sibling::div//textarea");
  private static final By NOTES_FIELD =
      By.xpath("//label[normalize-space()='Notes']/../following-sibling::div//textarea");
  private static final By SAVE_BUTTON =
      By.xpath(
          "//div[contains(@class,'oxd-form-actions')]//button[@type='submit' and contains(normalize-space(.),'Save')]");

  public AddOrganizationLocationPage(final WebDriver driver) {
    super(driver);
  }

  public AddOrganizationLocationPage fillForm(final OrganizationLocation location) {
    enterValue(NAME_FIELD, location.getName());
    enterValue(CITY_FIELD, location.getCity());
    enterValue(STATE_PROVINCE_FIELD, location.getStateProvince());
    enterValue(ZIP_POSTAL_CODE_FIELD, location.getZipPostalCode());
    selectFromDropdown(COUNTRY_DROPDOWN, location.getCountry());
    enterValue(PHONE_FIELD, location.getPhone());
    enterValue(FAX_FIELD, location.getFax());
    enterValue(ADDRESS_FIELD, location.getAddress());
    enterValue(NOTES_FIELD, location.getNotes());
    return this;
  }

  public AddOrganizationLocationPage save() {
    click(SAVE_BUTTON);
    return this;
  }
}
