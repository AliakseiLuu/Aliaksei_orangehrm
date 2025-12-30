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
        softAssert.assertTrue(dashboard.getSidepanel().isSidepanelVisible(),"Sidepanel is not displayed");
        softAssert.assertAll();
        driver.navigate().refresh();
    }
}
