package eu.senla;

import io.qameta.allure.*;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.OrganizationLocationsPage;

public class FilterOrganizationLocationTest extends BaseTest {

  @Test
  @Epic("Admin")
  @Feature("Organization management")
  @Story("Organization Page")
  @Severity(SeverityLevel.NORMAL)
  @Owner("AliakseiL")
  @Description("Фильтрация локаций организаций по стране")
  public void filterOrganizationLocationTest() {

    OrganizationLocationsPage organizationLocationsPage =
        new Dashboard(driver)
            .getSidepanel()
            .openAdmin()
            .openOrganizationLocationsPage()
            .filterLocationListByCountry("Belarus");

    Allure.step(
        "Проверяем, что все строки = 'Belarus'",
        () -> {
          List<String> countries = organizationLocationsPage.getCountryColumnValues();
          Assert.assertFalse(countries.isEmpty(), "Filtered list is empty");

          SoftAssert softAssert = new SoftAssert();
          countries.forEach(
              c -> softAssert.assertEquals(c, "Belarus", "Row with wrong country found: " + c));
          softAssert.assertAll();
        });
  }
}
