package co.com.lulobank.certification.employees.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumResourcesServices {
  DELETE_EMPLOYEE("/api/v1/delete/%s"),
  SELECT_AN_EMPLOYEE("/api/v1/employee/{id}"),
  SELECT_EMPLOYEES("/api/v1/employees"),
  ADD_EMPLOYEE("/api/v1/create");

  private final String resource;
}
