package utils;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDataUtils {

  private static final Faker FAKER = new Faker();

  public static Faker faker() {
    return FAKER;
  }

  // Форматы дат
  private static final DateTimeFormatter UI_FORMAT = DateTimeFormatter.ofPattern("yyyy-dd-MM");

  private TestDataUtils() {}

  // ---------- Строки ----------

  /** Обрезает строку до maxLength, не рвя последнее слово. */
  public static String capped(final String value, final int maxLength) {
    String trimmed = value.trim();
    if (trimmed.length() <= maxLength) {
      return trimmed;
    }
    String cut = trimmed.substring(0, maxLength);
    if (cut.contains(" ")) {
      cut = cut.substring(0, cut.lastIndexOf(' '));
    }
    return cut.trim();
  }

  public static String uniqueLocationName() {
    return capped("Location " + FAKER.number().digits(6), 30);
  }

  // ---------- Персональные данные ----------

  public static String phoneNumber() {
    return "+375" + FAKER.number().digits(9);
  }

  public static String faxNumber() {
    return FAKER.number().digits(8);
  }

  // ---------- Даты ----------

  public static String dateOfBirth() {
    LocalDate dob = LocalDate.now().minusDays(FAKER.number().numberBetween(18 * 365, 60 * 365));
    return dob.format(DateTimeFormatter.ISO_LOCAL_DATE);
  }

  /** Будущая дата в формате, который принимает UI-поле OrangeHRM (yyyy-dd-MM). */
  public static String futureDateForUi(final int daysAhead) {
    return LocalDate.now().plusDays(daysAhead).format(UI_FORMAT);
  }
}
