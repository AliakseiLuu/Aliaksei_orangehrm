package eu.senla;

import entities.OrganizationLocation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import utils.TestDataUtils;

public class AddOrganizationLocationTest extends BaseTest {

  @Test
  public void addOrganizationLocationTest() {

    OrganizationLocation location =
        OrganizationLocation.builder()
            .name(TestDataUtils.uniqueLocationName())
            .city(faker.address().city())
            .stateProvince(faker.address().state())
            .zipPostalCode(faker.address().zipCode())
            .country("Belarus")
            .phone(TestDataUtils.phoneNumber())
            .fax(TestDataUtils.faxNumber())
            .address(faker.address().fullAddress())
            .notes(faker.lorem().sentence())
            .build();

    boolean success =
        new Dashboard(driver)
            .getSidepanel()
            .openAdmin()
            .openOrganizationLocationsPage()
            .openAddOrganizationLocationPage()
            .fillForm(location)
            .save()
            .isSuccessToasterVisible();

    Assert.assertTrue(success, "Organization location doesn't created");
  }
}
