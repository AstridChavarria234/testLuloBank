package co.com.lulobank.certification.employees.utils.enums;

public enum EnumMessages {
  ADD_MESSAGE("Successfully! Record has been added.");

  private final String message;

  EnumMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
