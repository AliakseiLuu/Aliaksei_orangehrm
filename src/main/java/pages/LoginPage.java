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


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login (String name, String pass) {
        waitForClickable(loginButton);
        enterValue(username, name);
        enterValue(password, pass);
        click(loginButton);
    }

    public void openLoginPage () {
        driver.get(LOGIN_URL);
    }

    public void enterUserName (String name) {
        enterValue(username, name);
    }

    public void enterPassword (String pass) {
        enterValue(password, pass);
    }

    public void submit () {
        click(loginButton);
    }

    public String getUnsuccessfulLoginTaosterText () {
        waitForVisibility(unsuccessToaster);
        return getText(unsuccessToaster);
    }
}