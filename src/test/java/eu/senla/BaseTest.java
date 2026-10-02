package eu.senla;

import com.github.javafaker.Faker;
import config.AuthHelper;
import config.Config;
import core.DriverManager;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.TestDataUtils;

public class BaseTest {
  protected WebDriver driver;
  protected Faker faker = TestDataUtils.faker();
  protected String username = Config.get("app.username");
  protected String password = Config.get("app.password");
  protected boolean autoLogin =
      true; // для разделения между UI и API логином, переопределяется в тестах

  @BeforeMethod
  public void setUp(Method method, ITestResult result) {
    String name = method.getDeclaringClass().getSimpleName() + "_" + method.getName();
    DriverManager.initDriver(name);
    result.setAttribute("videoName", DriverManager.getTestName());
    driver = DriverManager.getDriver();
    driver.manage().window().maximize();
    if (autoLogin) {
      AuthHelper.login(driver, username, password);
    }
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
