package pages;

import entities.AssignLeave;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LeaveAssignLeavePage extends BasePage {

  private static final By EMPLOYEE_NAME_INPUT =
      By.xpath("//label[normalize-space()='Employee Name']/../following-sibling::div//input");
  private static final By LEAVE_TYPE_DROPDOWN =
      By.xpath(
          "//label[normalize-space()='Leave Type']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
  private static final By FROM_DATE_FIELD =
      By.xpath("//label[normalize-space()='From Date']/../following-sibling::div//input");
  private static final By TO_DATE_FIELD =
      By.xpath("//label[normalize-space()='To Date']/../following-sibling::div//input");
  private static final By PARTIAL_DAYS_DROPDOWN =
      By.xpath(
          "//label[normalize-space()='Partial Days']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
  private static final By START_DAY_DROPDOWN =
      By.xpath(
          "//label[normalize-space()='Start Day']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
  private static final By END_DAY_DROPDOWN =
      By.xpath(
          "//label[normalize-space()='End Day']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
  private static final By DURATION_DROPDOWN =
      By.xpath(
          "//label[normalize-space()='Duration']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
  private static final By START_DATE_FROM_FIELD =
      By.xpath(
          "//label[normalize-space()='Start Day']/ancestor::div[contains(@class,'oxd-grid-item')]"
              + "/following-sibling::div[.//label[normalize-space()='From']]//input");
  private static final By START_DATE_TO_FIELD =
      By.xpath(
          "//label[normalize-space()='Start Day']/ancestor::div[contains(@class,'oxd-grid-item')]"
              + "/following-sibling::div[.//label[normalize-space()='To']]//input");
  private static final By END_DATE_FROM_FIELD =
      By.xpath(
          "//label[normalize-space()='End Day']/ancestor::div[contains(@class,'oxd-grid-item')]"
              + "/following-sibling::div[.//label[normalize-space()='From']]//input");
  private static final By END_DATE_TO_FIELD =
      By.xpath(
          "//label[normalize-space()='End Day']/ancestor::div[contains(@class,'oxd-grid-item')]"
              + "/following-sibling::div[.//label[normalize-space()='To']]//input");
  private static final By COMMENTS_FIELD = By.xpath("//textarea");
  private static final By ASSIGN_BUTTON =
      By.xpath(
          "//div[contains(@class,'oxd-form-actions')]//button[@type='submit' and contains(normalize-space(.),'Assign')]");
  private static final By OK_BUTTON =
      By.xpath(
          "//button[contains(@class,'oxd-button--secondary') and contains(normalize-space(.),'Ok')]");
  private static final By LOGGED_USER_NAME = By.xpath("//span/p[@class='oxd-userdropdown-name']");
  private static final By DURATION_TEXT_FIRST_STRING =
      By.xpath("//p[contains(@class,'orangehrm-leave-duration')]");
  private static final By DURATION_TEXT_SECOND_STRING =
      By.xpath("(//p[contains(@class,'orangehrm-leave-duration')])[2]");
  private static final By FORM_TITLE = By.xpath("//h6[normalize-space()='Assign Leave']");
  private static final By EMPLOYEE_NAME_LABEL =
      By.xpath("//label[normalize-space()='Employee Name']");
  private static final By LEAVE_TYPE_LABEL = By.xpath("//label[normalize-space()='Leave Type']");
  private static final By FROM_DATE_LABEL = By.xpath("//label[normalize-space()='From Date']");
  private static final By TO_DATE_LABEL = By.xpath("//label[normalize-space()='To Date']");
  private static final By COMMENTS_LABEL = By.xpath("//label[normalize-space()='Comments']");
  private static final By SINGLE_DAY_FROM_FIELD =
      By.xpath(
          "//div[contains(@class,'oxd-grid-item')][.//label[normalize-space()='Duration']]"
              + "/following-sibling::div[.//label[normalize-space()='From']]//input");
  private static final By SINGLE_DAY_TO_FIELD =
      By.xpath(
          "//div[contains(@class,'oxd-grid-item')][.//label[normalize-space()='Duration']]"
              + "/following-sibling::div[.//label[normalize-space()='To']]//input");
  private static final By LEAVE_BALANCE_TEXT =
      By.xpath("//p[contains(@class,'orangehrm-leave-balance-text')]");

  public LeaveAssignLeavePage(final WebDriver driverParam) {
    super(driverParam);
  }

  public LeaveAssignLeavePage fillForm(final AssignLeave assignLeave) {
    selectFromDropdown(LEAVE_TYPE_DROPDOWN, assignLeave.getLeaveType());
    enterValue(FROM_DATE_FIELD, assignLeave.getFromDate());
    enterValue(TO_DATE_FIELD, assignLeave.getToDate());
    enterValue(COMMENTS_FIELD, assignLeave.getComments());
    return this;
  }

  public LeaveAssignLeavePage save() {
    click(ASSIGN_BUTTON);
    return this;
  }

  public LeaveAssignLeavePage selectFirstEmployee(final String typedText) {
    selectFirstAutocompleteSuggestion(EMPLOYEE_NAME_INPUT, typedText);
    return this;
  }

  public LeaveAssignLeavePage selectLeaveType(final String type) {
    selectFromDropdown(LEAVE_TYPE_DROPDOWN, type);
    return this;
  }

  public LeaveAssignLeavePage fillFromDate(final String from) {
    enterValue(FROM_DATE_FIELD, from);
    return this;
  }

  public LeaveAssignLeavePage fillToDate(final String to) {
    enterValue(TO_DATE_FIELD, to);
    unfocus();
    return this;
  }

  public LeaveAssignLeavePage selectPartialDays(final String option) {
    selectFromDropdown(PARTIAL_DAYS_DROPDOWN, option);
    return this;
  }

  public LeaveAssignLeavePage selectDuration(final String option) {
    selectFromDropdown(DURATION_DROPDOWN, option);
    return this;
  }

  public LeaveAssignLeavePage confirmInsufficientBalanceIfShown() {
    try {
      click(OK_BUTTON);
    } catch (TimeoutException ignored) {
    }
    return this;
  }

  public String takeCurrentUser() {
    return waitForVisibility(LOGGED_USER_NAME).getText();
  }

  public boolean isPartialDaysVisible() {
    return isDisplayed(PARTIAL_DAYS_DROPDOWN);
  }

  public boolean isPartialDaysHidden() {
    return !isDisplayed(PARTIAL_DAYS_DROPDOWN);
  }

  public boolean isStartDayVisible() {
    return isDisplayed(START_DAY_DROPDOWN);
  }

  public boolean isEndDayVisible() {
    return isDisplayed(END_DAY_DROPDOWN);
  }

  public boolean isDurationDropdownVisible() {
    return isDisplayed(DURATION_DROPDOWN);
  }

  public boolean isStartDateFromVisible() {
    return isDisplayed(START_DATE_FROM_FIELD);
  }

  public boolean isEndDateFromVisible() {
    return isDisplayed(END_DATE_FROM_FIELD);
  }

  public boolean isStartDateToVisible() {
    return isDisplayed(START_DATE_TO_FIELD);
  }

  public boolean isEndDateToVisible() {
    return isDisplayed(END_DATE_TO_FIELD);
  }

  public boolean isDurationTextVisible() {
    return isDisplayed(DURATION_TEXT_FIRST_STRING);
  }

  public boolean isEndDayDurationTextVisible() {
    return isDisplayed(DURATION_TEXT_SECOND_STRING);
  }

  public String getDurationText() {
    return getText(DURATION_TEXT_FIRST_STRING);
  }

  public String getEndDayDurationText() {
    return getText(DURATION_TEXT_SECOND_STRING);
  }

  public boolean isFormTitleVisible() {
    return isDisplayed(FORM_TITLE);
  }

  public boolean isEmployeeNameVisible() {
    return isDisplayed(EMPLOYEE_NAME_LABEL);
  }

  public boolean isLeaveTypeVisible() {
    return isDisplayed(LEAVE_TYPE_LABEL);
  }

  public boolean isFromDateVisible() {
    return isDisplayed(FROM_DATE_LABEL);
  }

  public boolean isToDateVisible() {
    return isDisplayed(TO_DATE_LABEL);
  }

  public boolean isCommentsVisible() {
    return isDisplayed(COMMENTS_LABEL);
  }

  public boolean isAssignButtonVisible() {
    return isDisplayed(ASSIGN_BUTTON);
  }

  public String getDurationSelectedValue() {
    return getText(DURATION_DROPDOWN);
  }

  public boolean isSingleDateFromVisible() {
    return isDisplayed(SINGLE_DAY_FROM_FIELD);
  }

  public boolean isSingleDateToVisible() {
    return isDisplayed(SINGLE_DAY_TO_FIELD);
  }

  public LeaveAssignLeavePage selectStartDay(final String option) {
    selectFromDropdown(START_DAY_DROPDOWN, option);
    return this;
  }

  public LeaveAssignLeavePage selectEndDay(final String option) {
    selectFromDropdown(END_DAY_DROPDOWN, option);
    return this;
  }
}
