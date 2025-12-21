package eu.senla;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.LoginPage;

public class AddingPimUser extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void testSuccessAddPIM_Employee (
            @Optional("Admin") String username, @Optional("admin123") String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login(username, password)
                .assertThatUrlAfterLoginIsCorrect()
                .assertDashboardHeaderIsDisplayed()
                .getLeftSideMenu()
                .openPIM();

    }
}