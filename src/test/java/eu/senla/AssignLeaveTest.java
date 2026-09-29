package eu.senla;

import entities.AssignLeave;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.LeaveAssignLeavePage;
import utils.TestDataUtils;

public class AssignLeaveTest extends BaseTest {

  @Test
  @Epic("Leave")
  @Feature("Assign Leave Management")
  @Story("Add Assign Leave")
  @Severity(SeverityLevel.NORMAL)
  @Owner("AliakseiL")
  @Description("Назначение Assign Leave текущему пользователю")
  public void assignLeaveTest() {

    LeaveAssignLeavePage leaveAssignLeavePage = new LeaveAssignLeavePage(driver);
    String name = leaveAssignLeavePage.takeCurrentUser();

    AssignLeave assignLeave =
        AssignLeave.builder()
            .leaveType("CAN - Personal")
            .fromDate(TestDataUtils.futureDateForUi(1))
            .toDate(TestDataUtils.futureDateForUi(2))
            .comments(faker.lorem().sentence())
            .build();

    boolean success =
        new Dashboard(driver)
            .getSidepanel()
            .openLeave()
            .openAssignLeave()
            .selectFirstEmployee(name)
            .fillForm(assignLeave)
            .save()
            .confirmInsufficientBalanceIfShown()
            .isSuccessToasterVisible();

    Allure.step(
        "Assign leave successfully created, success toaster appears",
        () -> Assert.assertTrue(success, "Assign leave doesn't created"));
  }
}
