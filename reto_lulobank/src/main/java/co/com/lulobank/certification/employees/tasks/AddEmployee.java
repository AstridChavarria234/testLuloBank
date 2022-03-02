package co.com.lulobank.certification.employees.tasks;

import static co.com.lulobank.certification.employees.utils.enums.EnumResourcesServices.ADD_EMPLOYEE;
import static co.com.lulobank.certification.employees.utils.enums.EnumVariablesSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.lulobank.certification.employees.interactions.servicios.ConsumeService;
import co.com.lulobank.certification.employees.models.ResponseSelectAnEmployee;
import co.com.lulobank.certification.employees.models.builders.EmployeeObjectBuilder;
import java.util.Map;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

@AllArgsConstructor
public class AddEmployee implements Task {

  private final Map<String, String> employeeInformation;

  public static Performable information(Map<String, String> employeeInformation) {
    return instrumented(AddEmployee.class, employeeInformation);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.remember(
        MODEL_EMPLOYEE.getVariableSession(),
        EmployeeObjectBuilder.buildEmployee(employeeInformation));

    actor.attemptsTo(
        ConsumeService.postSimple(
            ADD_EMPLOYEE.getResource(), actor.recall(MODEL_EMPLOYEE.getVariableSession())));

    actor.remember(
        RESPONSE_SELECT.getVariableSession(),
        SerenityRest.lastResponse().as(ResponseSelectAnEmployee.class));
  }
}
