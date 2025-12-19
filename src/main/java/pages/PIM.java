package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIM extends BasePage {

    public static final String DASHBOARD_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

    public PIM (WebDriver driver) {
        super(driver);
    }
}
