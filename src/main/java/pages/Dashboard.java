package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard extends BasePage {

    public static final String DASHBOARD_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    private static final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    public void isDashboardHeaderIsDisplayed () {
        waitForVisibility(dashboardHeader);
    }
}
