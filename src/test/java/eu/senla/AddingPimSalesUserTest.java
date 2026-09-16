package eu.senla;

import entities.PIMUser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;

public class AddingPimSalesUserTest extends BaseTest {

  @Test
  public void testSuccessAddPIM_Employee() {

    PIMUser pimUser =
        PIMUser.builder()
            .firstName(faker.name().firstName())
            .middleName(faker.name().nameWithMiddle())
            .lastName(faker.name().lastName())
            .employeeId(faker.number().digits(6))
            .build();

    boolean success =
        new Dashboard(driver)
            .waitForDashboardHeader()
            .getSidepanel()
            .openPIM()
            .clickAddButton()
            .fillForm(pimUser)
            .successUserCreation()
            .openJobDetails()
            .changeUserJobTitleToSales("Sales Representative")
            .isSuccessToasterVisible();

    Assert.assertTrue(success, "Pim Sales user doesn't created");
  }
}
