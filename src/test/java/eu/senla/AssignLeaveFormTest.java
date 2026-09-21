package eu.senla;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.LeaveAssignLeavePage;
import utils.TestDataUtils;

public class AssignLeaveFormTest extends BaseTest {

  @Test
  public void assignLeaveFormSingleDay() {

    SoftAssert soft = new SoftAssert();

    LeaveAssignLeavePage form = new Dashboard(driver).getSidepanel().openLeave().openAssignLeave();

    form.selectFirstEmployee("q");
    form.selectLeaveType("CAN - Personal");
    form.fillFromDate(TestDataUtils.futureDateForUi(1));
    form.fillToDate(TestDataUtils.futureDateForUi(1));

    soft.assertTrue(form.isFormTitleVisible(), "Form title 'Assign Leave' is not displayed");
    soft.assertTrue(form.isEmployeeNameVisible(), "Employee Name is not displayed");
    soft.assertTrue(form.isLeaveTypeVisible(), "Leave Type is not displayed");
    soft.assertTrue(form.isFromDateVisible(), "From Date is not displayed");
    soft.assertTrue(form.isToDateVisible(), "To Date is not displayed");
    soft.assertTrue(form.isCommentsVisible(), "Comments is not displayed");
    soft.assertTrue(form.isAssignButtonVisible(), "Assign button is not displayed");
    soft.assertTrue(
        form.isDurationDropdownVisible(),
        "Duration dropdown should be visible for a single-day leave");
    soft.assertTrue(
        form.isPartialDaysHidden(), "Partial Days should be hidden for a single-day leave");
    soft.assertEquals(
        form.getDurationSelectedValue(), "Full Day", "Duration default should be Full Day");

    form.selectDuration("Specify Time");
    soft.assertTrue(
        form.isSingleDateFromVisible(),
        "Start time field should appear after selecting 'Specify Time'");
    soft.assertTrue(
        form.isSingleDateToVisible(),
        "End time field should appear after selecting 'Specify Time'");
    soft.assertTrue(
        form.isDurationTextVisible(), "Field with duration calculated value is not displayed");

    soft.assertAll();
  }

  @Test
  public void assignLeaveFormMultiDay() {

    SoftAssert soft = new SoftAssert();

    LeaveAssignLeavePage form = new Dashboard(driver).getSidepanel().openLeave().openAssignLeave();

    form.selectFirstEmployee("q");
    form.selectLeaveType("CAN - Personal");
    form.fillFromDate(TestDataUtils.futureDateForUi(1));
    form.fillToDate(TestDataUtils.futureDateForUi(2));

    soft.assertTrue(
        form.isPartialDaysVisible(), "Partial Days should be visible for a multi-day leave");
    soft.assertFalse(
        form.isDurationDropdownVisible(),
        "Duration dropdown should be hidden for a multi-day leave");

    form.selectPartialDays("All Days");
    soft.assertTrue(
        form.isDurationDropdownVisible(),
        "Duration dropdown should be visible for 'All Days' item in Partial days field");
    soft.assertFalse(form.isStartDayVisible(), "Time fields should not appear for 'All Days'");
    soft.assertFalse(form.isEndDayVisible(), "Time fields should not appear for 'All Days'");

    form.selectDuration("Specify Time");
    soft.assertTrue(
        form.isSingleDateFromVisible(),
        "Start time field should appear after selecting 'Specify Time'");
    soft.assertTrue(
        form.isSingleDateToVisible(),
        "End time field should appear after selecting 'Specify Time'");
    soft.assertTrue(
        form.isDurationTextVisible(), "Field with duration calculated value is not displayed");
    soft.assertFalse(form.isEndDayVisible(), "Time fields should not appear for 'All Days'");

    form.selectPartialDays("Start and End Day");
    soft.assertTrue(form.isStartDayVisible(), "Start Day should appear");
    soft.assertTrue(form.isEndDayVisible(), "End Day should appear");

    form.selectStartDay("Specify Time");
    soft.assertTrue(
        form.isStartDateFromVisible(),
        "Start time field should appear after selecting 'Specify Time'");
    soft.assertTrue(
        form.isStartDateToVisible(), "End time field should appear after selecting 'Specify Time'");
    soft.assertTrue(
        form.isDurationTextVisible(), "Field with duration calculated value is not displayed");
    soft.assertEquals(form.getDurationText(), "8.00", "Duration text should be calculated");

    form.selectEndDay("Specify Time");
    soft.assertTrue(
        form.isEndDateFromVisible(),
        "Start time field should appear after selecting 'Specify Time'");
    soft.assertTrue(
        form.isEndDateToVisible(), "End time field should appear after selecting 'Specify Time'");
    soft.assertTrue(
        form.isEndDayDurationTextVisible(),
        "Field with duration calculated value is not displayed");
    soft.assertEquals(form.getEndDayDurationText(), "8.00", "Duration text should be calculated");

    soft.assertAll();
  }
}
