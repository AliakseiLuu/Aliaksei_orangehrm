package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewJobTitleListPage extends BasePage {

    private final By addButton =
            By.xpath("//div/button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

    public ViewJobTitleListPage(WebDriver driverParam) {
        super(driverParam);
    }

    public AddJobTitlePage openAddJobTitlesPage() {
        click(addButton);
        return new AddJobTitlePage(getDriver());
    }
}
