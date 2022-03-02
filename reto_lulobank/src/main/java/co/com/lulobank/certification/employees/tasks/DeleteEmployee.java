package co.com.lulobank.certification.employees.tasks;

import static co.com.lulobank.certification.employees.utils.enums.EnumResourcesServices.DELETE_EMPLOYEE;
import static co.com.lulobank.certification.employees.utils.enums.EnumVariablesSesion.RESPONSE_DELETE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.lulobank.certification.employees.interactions.servicios.ConsumeService;
import co.com.lulobank.certification.employees.models.ResponseDeleteEmployee;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

@AllArgsConstructor
public class DeleteEmployee implements Task {

  private final String idEmployee;

  public static Performable byId(String idEmployee) {
    return instrumented(DeleteEmployee.class, idEmployee);
  }

  @Step("{0} delete employee")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsumeService.deleteById(DELETE_EMPLOYEE.getResource(), idEmployee));
    actor.remember(
        RESPONSE_DELETE.getVariableSession(),
        SerenityRest.lastResponse().as(ResponseDeleteEmployee.class));
  }
}
