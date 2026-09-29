package utils;

import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Slf4j
@UtilityClass
public class ScreenshotUtil {

  public void takeScreenshot(final WebDriver driver) {
    byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    Allure.getLifecycle().addAttachment("Screenshot on failure", "image/png", "png", bytes);

    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    String dirPath = "target/surefire-reports/screenshots/";

    File dir = new File(dirPath);
    if (!dir.exists()) {
      dir.mkdirs();
    }

    File dest = new File(dirPath + timestamp + ".png");
    try {
      Files.copy(screenshot.toPath(), dest.toPath());
      log.error("Saved screenshot to: {}", dest.getAbsoluteFile());
    } catch (IOException e) {
      log.error("Screenshot can't be saved.");
    }
  }
}
