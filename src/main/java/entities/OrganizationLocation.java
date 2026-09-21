package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationLocation {
  private final String name;
  private final String city;
  private final String stateProvince;
  private final String zipPostalCode;
  private final String country;
  private final String phone;
  private final String fax;
  private final String address;
  private final String notes;
}
