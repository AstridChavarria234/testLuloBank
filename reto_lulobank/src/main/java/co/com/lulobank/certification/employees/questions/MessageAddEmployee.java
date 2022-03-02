package co.com.lulobank.certification.employees.questions;

import static co.com.lulobank.certification.employees.utils.enums.EnumMessages.ADD_MESSAGE;
import static co.com.lulobank.certification.employees.utils.enums.EnumVariablesSesion.RESPONSE_SELECT;

import co.com.lulobank.certification.employees.models.ResponseSelectAnEmployee;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class MessageAddEmployee implements Question<Boolean> {

  public static MessageAddEmployee validateAdd() {
    return new MessageAddEmployee();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    ResponseSelectAnEmployee responseSelectAnEmployee =
        actor.recall(RESPONSE_SELECT.getVariableSession());

    return responseSelectAnEmployee.getMessage().equalsIgnoreCase(ADD_MESSAGE.getMessage());
  }
}
