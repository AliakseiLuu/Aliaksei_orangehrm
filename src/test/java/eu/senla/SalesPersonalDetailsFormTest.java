package eu.senla;

import entities.PersonalDetailBlock;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import utils.TestDataUtils;

public class SalesPersonalDetailsFormTest extends BaseTest {

  @Test
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
