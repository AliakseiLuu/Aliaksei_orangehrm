package eu.senla;

import entities.PIMUser;
import entities.PersonalDetailBlock;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import utils.TestDataUtils;

public class PimSalesUserTest extends BaseTest {

  @Test
  @Epic("PIM")
  @Feature("Employee management")
  @Story("Add employee")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("AliakseiL")
  @Description("Создание PIM-сотрудника и назначение должности Sales Representative")
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

    Allure.step(
        "Assert: тостер об успехе виден",
        () -> Assert.assertTrue(success, "Pim Sales user doesn't created"));
  }

  @Test(dependsOnMethods = "testSuccessAddPIM_Employee")
  @Epic("PIM")
  @Feature("Employee Management")
  @Story("Personal details form")
  @Severity(SeverityLevel.NORMAL)
  @Owner("AliakseiL")
  @Description("Редактирование информации на странице Personal details для Sales юзера")
  void salesPersonalDetailsFormTest() {

    PersonalDetailBlock personalDetailBlock =
        PersonalDetailBlock.builder()
            .firstNameField(faker.name().firstName())
            .middleNameField(faker.name().firstName())
            .lastNameField(faker.name().lastName())
            .employeeIdField(faker.number().digits(9))
            .otherIdField(faker.idNumber().valid())
            .driversLicenseNumberField(faker.idNumber().valid())
            .licenseExpiryDateField(TestDataUtils.futureDateForUi(365))
            .nationalityDropDownField("Belarus")
            .materialStatusDropDownField("Single")
            .dateOfBirthField(TestDataUtils.dateOfBirth())
            .build();

    boolean success =
        new Dashboard(driver)
            .getSidepanel()
            .openPIM()
            .filteringEmployeeListByJobTitle("Sales Representative")
            .search()
            .openSalesPersonalDetailPage("Sales Representative")
            .assertVisibleAllFieldsInThePersonalDetailsBlock()
            .fillForm(personalDetailBlock)
            .isSuccessToasterVisible();

    Allure.step(
        "Personal details successfully changed ans saved, success toaster appears",
        () -> Assert.assertTrue(success, "Personal details were not saved"));
  }
}
