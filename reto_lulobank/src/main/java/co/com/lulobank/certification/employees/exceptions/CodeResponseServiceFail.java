package co.com.lulobank.certification.employees.exceptions;

public class CodeResponseServiceFail extends AssertionError {

  public static final String CODE_RESPONSE_SERVICE =
      "The response code obtained is not the same as expected";

  public CodeResponseServiceFail(String message, Throwable cause) {
    super(message, cause);
  }
}
