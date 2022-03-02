package co.com.lulobank.certification.employees.exceptions;

public class DeleteFail extends AssertionError {

  public static final String DELETE_FAIL = "The employee was not successfully deleted";

  public DeleteFail(String message, Throwable cause) {
    super(message, cause);
  }
}
