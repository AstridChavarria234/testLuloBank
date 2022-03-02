package co.com.lulobank.certification.employees.exceptions;

public class SelectFail extends AssertionError {

  public static final String SELECT_FAIL = "The employee was not successfully selected";

  public SelectFail(String message, Throwable cause) {
    super(message, cause);
  }
}
