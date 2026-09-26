package listener;

import config.Config;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class VideoListener implements ITestListener {
  private static final HttpClient HTTP =
      HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();

  @Override
  public void onFinish(final ITestContext context) {
    if (!Boolean.parseBoolean(Config.get("selenoid.enabled"))) {
      return; // локальный запуск без Selenoid — видео нет, нечего чистить
    }

    List<String> deleteNames = new ArrayList<>();

    // прошедшие и пропущенные тесты → видео удаляем
    context.getPassedTests().getAllResults().forEach(r -> collect(r, deleteNames));
    context.getSkippedTests().getAllResults().forEach(r -> collect(r, deleteNames));

    // упавшие тесты НЕ трогаем — их видео остаются как артефакт падения
    context
        .getFailedTests()
        .getAllResults()
        .forEach(r -> System.out.println("KEEP video (failed): " + videoName(r)));

    for (String name : deleteNames) {
      deleteVideo(name);
    }
  }

  private void collect(final ITestResult result, final List<String> names) {
    String name = videoName(result);
    if (name != null) {
      names.add(name);
    }
  }

  private String videoName(final ITestResult result) {
    Object attr = result.getAttribute("videoName");
    return attr != null ? attr.toString() : null;
  }

  /** DELETE {selenoid-base}/video/{name}.mp4 */
  private void deleteVideo(final String videoName) {
    String base =
        Config.get("selenoid.url")
            .replace("/wd/hub", ""); // http://localhost:4444/wd/hub → http://localhost:4444
    String url = base + "/video/" + videoName + ".mp4";

    for (int attempt = 1; attempt <= 3; attempt++) {
      try {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).DELETE().build();
        int code = HTTP.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();
        if (code == 200) {
          System.out.println("Video deleted: " + videoName);
          return;
        }
        if (code == 404) {
          Thread.sleep(1000); // файл ещё финализируется — подождём и попробуем снова
          continue;
        }
        System.out.printf("Unexpected status %d for %s%n", code, videoName);
        return;
      } catch (Exception e) {
        System.out.println("Delete failed: " + e.getMessage());
        return;
      }
    }
  }
}
