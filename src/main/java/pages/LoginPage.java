package pages;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private final By username = By.name("username");
  private final By password = By.name("password");
  private final By loginButton = By.className("orangehrm-login-button");
  private final By unsuccessToaster = By.cssSelector("p.oxd-alert-content-text");
  private final String loginUrl = Config.get("app.url");

  public LoginPage(final WebDriver driver) {
    super(driver);
  }

  public Dashboard login(final String name, final String pass) {
    getDriver().get(loginUrl);
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

  public String getCurrentUrl() {
    return getDriver().getCurrentUrl();
  }
}
