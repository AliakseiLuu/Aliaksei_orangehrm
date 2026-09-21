package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PIMUser {

  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String employeeId;
}
