package config;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.Map;

public class AuthApi {

  private AuthApi() {}

  public static Map<String, String> getSessionCookies() {

    String base = "https://" + Config.get("app.domain");

    Response loginResponse = given().baseUri(base).get("/web/index.php/auth/login");

    System.out.println("Initial cookies = " + loginResponse.cookies());

    String html = loginResponse.getBody().asString();

    String csrfToken = html.split(":token=\"&quot;")[1].split("&quot;\"")[0];
    System.out.println("csrfToken = " + csrfToken);

    Response validateResponse =
        given()
            .baseUri(base)
            .cookies(loginResponse.cookies())
            .formParam("username", Config.get("app.username"))
            .formParam("password", Config.get("app.password"))
            .formParam("_token", csrfToken)
            .post("/web/index.php/auth/validate");

    return validateResponse.cookies();
  }
}
