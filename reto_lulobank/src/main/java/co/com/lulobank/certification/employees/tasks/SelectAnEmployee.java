package co.com.lulobank.certification.employees.tasks;

import static co.com.lulobank.certification.employees.utils.enums.EnumResourcesServices.SELECT_AN_EMPLOYEE;
import static co.com.lulobank.certification.employees.utils.enums.EnumVariablesSesion.RESPONSE_SELECT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.lulobank.certification.employees.interactions.servicios.ConsumeService;
import co.com.lulobank.certification.employees.models.ResponseSelectAnEmployee;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

@AllArgsConstructor
public class SelectAnEmployee implements Task {

  private final String idEmployee;

  public static Performable byId(String idEmployee) {
    return instrumented(SelectAnEmployee.class, idEmployee);
  }

  @Step("{0} select employee")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsumeService.getById(SELECT_AN_EMPLOYEE.getResource(), idEmployee));

    actor.remember(
        RESPONSE_SELECT.getVariableSession(),
        SerenityRest.lastResponse().as(ResponseSelectAnEmployee.class));
  }
}
