package eu.senla;

import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;

public class LogoutTest extends BaseTest {

  @Test
  public void Logout() {

    Dashboard dashboard = new Dashboard(driver);

    dashboard.getTopbarHeader().logout();

    Assert.assertEquals(dashboard.getCurrentUrl(), Config.get("app.url"), "Ссылки не совпадают");
  }
}
