package eu.senla;

import net.bytebuddy.utility.RandomString;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class UnsuccessLogin extends BaseTest {

  // Параметризованный тест с программно заданными параметрами через @DataProvider
  @Test(dataProvider = "getCredentials", description = "Failed login with invalid credentials")
  void invalidCredentialsTest(String username, String password) {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, password);

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals("Invalid credentials", loginPage.getUnsuccessfulLoginTaosterText());
    softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.LOGIN_URL);
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
