package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalDetailBlock {

  private final String firstNameField;
  private final String middleNameField;
  private final String lastNameField;
  private final String employeeIdField;
  private final String otherIdField;
  private final String driversLicenseNumberField;
  private final String licenseExpiryDateField;
  private final String nationalityDropDownField;
  private final String materialStatusDropDownField;
  private final String dateOfBirthField;
}
