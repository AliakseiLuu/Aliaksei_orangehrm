package entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PIMUser {
  private final String firstName;
  private final String middleName;
  private final String lastName;
}
