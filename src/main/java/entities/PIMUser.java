package entities;

public class PIMUser {
  private final String firstName;
  private final String middleName;
  private final String lastName;

  private PIMUser(final Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.middleName = builder.middleName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public static class Builder {
    private String firstName;
    private String lastName;
    private String middleName;

    public Builder setFirstName(final String firstNameValue) {
      this.firstName = firstNameValue;
      return this;
    }

    public Builder setLastName(final String lastNameValue) {
      this.lastName = lastNameValue;
      return this;
    }

    public Builder setMiddleName(final String middleNameValue) {
      this.middleName = middleNameValue;
      return this;
    }

    public PIMUser build() {
      return new PIMUser(this);
    }
  }
}
