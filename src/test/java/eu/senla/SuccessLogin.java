package eu.senla;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class SuccessLogin extends BaseTest {

  // Параметризованный тест с параметрами заданными через testng.xml файл
  @Test
  @Parameters({"username", "password"})
  public void testSuccessLogin(
      @Optional("Admin") String username, @Optional("admin123") String password) {

    Admin admin = new Admin(driver);
    Dashboard dashboard = new Dashboard(driver);

    LoginPage loginPage = new LoginPage(driver);
    loginPage.openLoginPage();
    loginPage.login(username, password);
    dashboard.isDashboardHeaderIsDisplayed();

    String URLAfterLogin = driver.getCurrentUrl();
    Assert.assertEquals(URLAfterLogin, Dashboard.DASHBOARD_URL, "Ссылки не совпадают");

    LeftSideMenu leftSideMenu = new LeftSideMenu(driver);
    Assert.assertTrue(leftSideMenu.isLeftSideMenuVisible(), "Левое меню отображается после логина");
    leftSideMenu.openAdmin();

    admin
            .enterUserName("Admin")
            .selectItemInUserRole()
            .enterEmployeeName("vasia")
            .searchEmployees();




    /*
    driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Search ']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/div[@class='oxd-table-filter']")));

    driver
        .findElement(
            By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input"))
        .sendKeys("Admin");
    driver.findElement(By.xpath("//div[text()='-- Select --']")).click();
    driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']")).click();
    driver
        .findElement(with(By.tagName("input")).below(By.xpath("//label[text()='Employee Name']")))
        .sendKeys("Demo");
    driver.findElement(By.xpath("//button[text()=' Search ']")).click();
    driver.findElement(By.xpath("//button[text()=' Add ']")).click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/div[@class='orangehrm-card-container']")));*/
  }
}
