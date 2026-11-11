package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

  private static final int MAX_RETRY = 2; // сколько раз перезапускать упавший тест
  private int retryCount = 0;

  @Override
  public boolean retry(final ITestResult result) {
    if (retryCount < MAX_RETRY) {
      retryCount++;
      return true; // перезапустить тест
    }
    return false; // лимит исчерпан, тест остаётся упавшим
  }
}
