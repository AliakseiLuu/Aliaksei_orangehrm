package pages;

import config.Config;
import io.qameta.allure.Step;
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

  @Step("Login to the application as admin")
  public Dashboard login(final String name, final String pass) {
    getDriver().get(loginUrl);
    waitForClickable(loginButton);
    enterValue(username, name);
    enterValue(password, pass);
    click(loginButton);
    return new Dashboard(getDriver());
  }

  public String getUnsuccessfulLoginTaosterText() {
    waitForVisibility(unsuccessToaster);
    return getText(unsuccessToaster);
  }
}
