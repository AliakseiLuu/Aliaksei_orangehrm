package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftSideMenu extends BasePage {

    protected By leftSideMenu = By.xpath("//div/ul[@class='oxd-main-menu']");
    private final By dashboard = By.xpath("//a[@href='/web/index.php/dashboard/index']");
    private final By pim = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
    private final By admin = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");

    public LeftSideMenu(WebDriver driver) {
        super(driver);}

    public boolean isLeftSideMenuVisible() {
        try {
            waitForVisibility(leftSideMenu);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void openAdmin() {
        waitForVisibility(admin).click();
    }

    public void openPIM() {
        waitForVisibility(pim).click();
    }

    public void openDashboard() {
        waitForVisibility(dashboard).click();
    }
}
