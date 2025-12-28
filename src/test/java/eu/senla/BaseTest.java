package eu.senla;

import com.github.javafaker.Faker;
import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  protected WebDriver driver;
  protected Faker faker = new Faker();

  @BeforeMethod
  public void setUp() {
      driver = DriverManager.getDriver();
      driver.manage().window().maximize();
  }

  @AfterMethod
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
