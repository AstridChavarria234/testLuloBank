package co.com.lulobank.certification.employees.tasks;

import static co.com.lulobank.certification.employees.utils.enums.EnumResourcesServices.SELECT_EMPLOYEES;
import static co.com.lulobank.certification.employees.utils.enums.EnumVariablesSesion.RESPONSE_SELECT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.lulobank.certification.employees.interactions.servicios.ConsumeService;
import co.com.lulobank.certification.employees.models.ResponseSelectEmployees;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

@AllArgsConstructor
public class SelectEmployees implements Task {

  public static Performable all() {
    return instrumented(SelectEmployees.class);
  }

  @Step("{0} select employees")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsumeService.getAll(SELECT_EMPLOYEES.getResource()));

    actor.remember(
        RESPONSE_SELECT.getVariableSession(),
        SerenityRest.lastResponse().as(ResponseSelectEmployees.class));
  }
}
