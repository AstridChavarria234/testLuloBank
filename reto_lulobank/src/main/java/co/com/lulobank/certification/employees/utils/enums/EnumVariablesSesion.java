package co.com.lulobank.certification.employees.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumVariablesSesion {
  MODEL_EMPLOYEE("Model of employeee"),
  RESPONSE_SELECT("response select"),
  RESPONSE_SELECT_ALL("response select"),
  RESPONSE_DELETE("response delete");

  private final String variableSession;
}
