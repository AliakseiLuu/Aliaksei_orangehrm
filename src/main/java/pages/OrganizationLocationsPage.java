package pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrganizationLocationsPage extends BasePage {

  private static final By ADD_BUTTON =
      By.xpath("//div/button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
  private static final By COUNTRY_DROPDOWN =
      By.xpath(
          "//label[normalize-space()='Country']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
  private static final By SEARCH_BUTTON = By.xpath("//div//button[@type='submit']");
  private static final By TABLE_ROWS =
      By.xpath("//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')]");
  private static final By COUNTRY_CELLS =
      By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[@role='cell'][4]");

  public OrganizationLocationsPage(final WebDriver driverParam) {
    super(driverParam);
  }

  public AddOrganizationLocationPage openAddOrganizationLocationPage() {
    click(ADD_BUTTON);
    return new AddOrganizationLocationPage(getDriver());
  }

  public OrganizationLocationsPage filterLocationListByCountry(final String country) {
    selectFromDropdown(COUNTRY_DROPDOWN, country);
    click(SEARCH_BUTTON);
    waitForVisibility(TABLE_ROWS);
    return this;
  }

  public List<String> getCountryColumnValues() {
    waitForVisibility(By.xpath("//div[@class='oxd-table-body']")); // дождаться отрисовки
    return getDriver().findElements(COUNTRY_CELLS).stream()
        .map(e -> e.getText().trim())
        .collect(Collectors.toList());
  }
}
