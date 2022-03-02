package co.com.lulobank.certification.employees.questions;

import static co.com.lulobank.certification.employees.utils.enums.EnumVariablesSesion.RESPONSE_SELECT;

import co.com.lulobank.certification.employees.models.ResponseSelectAnEmployee;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class InformationAnEmployee implements Question<Boolean> {

  private final Boolean validateDelete;

  public static InformationAnEmployee validateDelete(Boolean validateDelete) {
    return new InformationAnEmployee(validateDelete);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    ResponseSelectAnEmployee responseSelectAnEmployee =
        actor.recall(RESPONSE_SELECT.getVariableSession());

    return validateDelete == (responseSelectAnEmployee.getData() == null);
  }
}
