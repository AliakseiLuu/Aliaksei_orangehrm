package eu.senla;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UnsuccessLogin extends BaseClass {

  // Параметризованный тест с программно заданными параметрами через @DataProvider
  @Test(dataProvider = "getCredentials", description = "Failed login with invalid credentials")
  void invalidCredentialsTest(String username, String password) {
    driver.get(LOGIN_URL);
    wait.until(d -> driver.findElement(By.xpath("//input[@name='username']")).isDisplayed());
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    wait.until(d -> driver.findElement(By.cssSelector("p.oxd-alert-content-text")).isDisplayed());
    String alert = driver.findElement(By.cssSelector(".oxd-alert-content-text")).getText();

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals("Invalid credentials", alert);
    softAssert.assertEquals(driver.getCurrentUrl(), LOGIN_URL);
    softAssert.assertAll();
    driver.navigate().refresh();
  }

  @DataProvider(name = "getCredentials")
  public Object[][] getCredentials() {
    return new Object[][] {
      {"Admin", RandomString.make()},
      {RandomString.make(), "admin123"},
      {RandomString.make(), RandomString.make()}
    };
  }
}
