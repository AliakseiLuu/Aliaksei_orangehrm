package eu.senla;

import config.Config;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.LoginPage;

public class DashboardElementsTest extends BaseTest {

  String username = Config.get("app.username");
  String password = Config.get("app.password");

  @Test
  void dashboardElementsIsCorrect() {

    LoginPage loginPage = new LoginPage(driver);

    Dashboard dashboard = loginPage.login(username, password);

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(dashboard.isHeaderVisible(), "Header is not visible");
    softAssert.assertTrue(
        dashboard.getSidepanel().isSidepanelVisible(), "Sidepanel is not displayed");
    softAssert.assertTrue(
        dashboard.isTimeAtWorkSheetVisible(), "Time at work sheet is not displayed");
    softAssert.assertTrue(dashboard.isMyActionsSheetVisible(), "My Actions Sheet is not displayed");
    softAssert.assertTrue(
        dashboard.isQuickLaunchSheetVisible(), "Quick Launch sheet is not displayed");
    softAssert.assertTrue(
        dashboard.isBuzzLatestPostsSheetVisible(), "Buzz Latest Posts sheet is not displayed");
    softAssert.assertTrue(
        dashboard.isEmployeesOnLeaveTodaySheetVisible(),
        "Employees On Leave Today is not displayed");
    softAssert.assertTrue(
        dashboard.isEmployeeDistributionBySubUnitSheetVisible(),
        "Employee Distribution By Sub Unit is not displayed");
    softAssert.assertTrue(
        dashboard.isEmployeeDistributionByLocationSheetVisible(),
        "Employee Distribution By Location sheet is not displayed");
    softAssert.assertAll();
    driver.navigate().refresh();
  }
}
