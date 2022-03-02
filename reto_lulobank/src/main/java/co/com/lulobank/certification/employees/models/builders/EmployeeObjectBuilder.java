package co.com.lulobank.certification.employees.models.builders;

import co.com.lulobank.certification.employees.models.InformationEmployee;
import java.util.Map;

public final class EmployeeObjectBuilder {
  private EmployeeObjectBuilder() {}

  public static InformationEmployee buildEmployee(Map<String, String> employeeInformation) {

    return InformationEmployee.builder()
        .employee_name(employeeInformation.get("employee_name"))
        .employee_salary(Integer.parseInt(employeeInformation.get("employee_salary")))
        .employee_age(Integer.parseInt(employeeInformation.get("employee_age")))
        .profile_image(employeeInformation.get("profile_image"))
        .build();
  }
}
