package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Dashboard extends BasePage {

    public static final String DASHBOARD_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    private static final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    public Dashboard assertDashboardHeaderIsDisplayed() {
        Assert.assertTrue(isDisplayed(dashboardHeader), "Dashboard header is not displayed");
        return this; // возвращаем Dashboard для цепочки
    }

    public Dashboard assertThatUrlAfterLoginIsCorrect() {
        Assert.assertEquals(driver.getCurrentUrl(), DASHBOARD_URL, "Ссылки не совпадают");
        return this;
    }

    public LeftSideMenu getLeftSideMenu() {
        return new LeftSideMenu(driver);
    }
}