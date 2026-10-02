package listener;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class BrowserLabelListener implements IInvokedMethodListener {
  @Override
  public void afterInvocation(final IInvokedMethod method, final ITestResult result) {
    if (method.isTestMethod()) {
      String browser = System.getProperty("browser", "chrome");

      Allure.getLifecycle()
          .updateTestCase(
              exec -> {
                exec.getLabels().add(new Label().setName("browser").setValue(browser));
                exec.getLabels().add(new Label().setName("tag").setValue(browser));
                exec.getLabels()
                    .add(
                        new Label()
                            .setName("threadCount")
                            .setValue(System.getProperty("threadCount", "1")));
              });
    }
  }
}
