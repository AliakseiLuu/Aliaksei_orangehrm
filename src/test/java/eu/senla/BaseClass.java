package eu.senla;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
  protected String Dachbord_URL =
      "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

  public void successLogin(String username, String password) {
    driver.get(LOGIN_URL);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
    wait.until(ExpectedConditions.elementToBeClickable(By.className("orangehrm-login-button")));

    driver.findElement(By.name("username")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.className("orangehrm-login-button")).click();
  }

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
