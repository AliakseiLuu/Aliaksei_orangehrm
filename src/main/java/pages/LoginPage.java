package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private final By username = By.name("username");
  private final By password = By.name("password");
  private final By loginButton = By.className("orangehrm-login-button");
  public static final String LOGIN_URL =
      "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
  private final By unsuccessToaster = By.cssSelector("p.oxd-alert-content-text");
  private final By headerAfterLogin = By.className("oxd-topbar-header");

  public LoginPage(final WebDriver driver) {
    super(driver);
  }

  public Dashboard login(final String name, final String pass) {
    getDriver().get(LOGIN_URL);
    waitForClickable(loginButton);
    enterValue(username, name);
    enterValue(password, pass);
    click(loginButton);
    return new Dashboard(getDriver());
  }

  public LoginPage enterUserName(final String name) {
    enterValue(username, name);
    return this;
  }

  public LoginPage enterPassword(final String pass) {
    enterValue(password, pass);
    return this;
  }

  public LoginPage submit() {
    click(loginButton);
    return this;
  }

  public String getUnsuccessfulLoginTaosterText() {
    waitForVisibility(unsuccessToaster);
    return getText(unsuccessToaster);
  }
}
