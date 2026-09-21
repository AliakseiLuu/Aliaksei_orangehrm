package eu.senla;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.OrganizationLocationsPage;

public class FilterOrganizationLocationTest extends BaseTest {

  @Test
  public void filterOrganizationLocationTest() {

    OrganizationLocationsPage organizationLocationsPage =
        new Dashboard(driver)
            .getSidepanel()
            .openAdmin()
            .openOrganizationLocationsPage()
            .filterLocationListByCountry("Belarus");

    List<String> countries = organizationLocationsPage.getCountryColumnValues();

    Assert.assertFalse(countries.isEmpty(), "Filtered list is empty");

    SoftAssert softAssert = new SoftAssert();
    countries.forEach(
        c -> softAssert.assertEquals(c, "Belarus", "Row with wrong country found: " + c));
    softAssert.assertAll();
  }
}
