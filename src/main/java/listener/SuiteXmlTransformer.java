package listener;

import java.util.List;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

public class SuiteXmlTransformer implements IAlterSuiteListener {

  @Override
  public void alter(final List<XmlSuite> suites) {
    String threadCount = System.getProperty("threadCount", "1");
    String parallel = System.getProperty("parallel", "methods");

    for (XmlSuite suite : suites) {
      suite.setThreadCount(Integer.parseInt(threadCount));
      suite.setParallel(XmlSuite.ParallelMode.getValidParallel(parallel));
    }
  }
}
