package listener;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class BrowserLabelListener implements IInvokedMethodListener {
  @Override
  public void beforeInvocation(final IInvokedMethod method, final ITestResult result) {
    if (method.isTestMethod()) {
      String browser = System.getProperty("browser", "chrome");
      String threadCount = System.getProperty("threadCount", "1");

      Allure.getLifecycle()
          .updateTestCase(
              exec -> {
                exec.getLabels().add(new Label().setName("browser").setValue(browser));
                exec.getLabels().add(new Label().setName("tag").setValue(browser));
                exec.getLabels().add(new Label().setName("threadCount").setValue(threadCount));
                String base = exec.getHistoryId();
                if (!base.endsWith("[" + browser + "]")) {
                  exec.setHistoryId(base + "[" + browser + "]");
                }
              });
    }
  }
}
