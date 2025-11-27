package eu.senla;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class OrangeHRMTests {
  private WebDriver driver;
  private WebDriverWait wait;

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  }

  public void successLogin(String username, String password) {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
    wait.until(ExpectedConditions.elementToBeClickable(By.className("orangehrm-login-button")));

    driver.findElement(By.name("username")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.className("orangehrm-login-button")).click();
  }

  @Test
  public void testSuccessLogin() {
    successLogin("Admin", "admin123");
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/ul[@class='oxd-main-menu']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")));

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
            By.xpath("//div/div[@class='orangehrm-card-container']")));
  }

  @Test
  public void testSuccessAddPIM_Employee() {
    successLogin("Admin", "admin123");
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/ul[@class='oxd-main-menu']")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='PIM']")));

    driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']")));

    driver.findElement(By.xpath("//button[text()=' Add ']")).click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/div[@class='oxd-input-group']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@name='firstName']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@name='lastName']")));

    driver.findElement(By.xpath("//div/input[@name='firstName']")).sendKeys("FirstNameTestUser");
    driver.findElement(By.xpath("//div/input[@name='lastName']")).sendKeys("LastNameTestUser");

    driver.findElement(By.xpath("//button[text()=' Save ']")).click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/div[contains(@class,'oxd-toast')]")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p[text()='Success']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/h6[text()='Personal Details']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/h6[normalize-space(.)!='']")));
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
