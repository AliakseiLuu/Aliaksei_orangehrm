package entities;

public class PIMUser {
  private final String firstName;
  private final String middleName;
  private final String lastName;

  private PIMUser(Builder builder) {
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

    public Builder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder setMiddleName(String middleName) {
      this.middleName = middleName;
      return this;
    }

    public PIMUser build() {
      return new PIMUser(this);
    }
  }
}
