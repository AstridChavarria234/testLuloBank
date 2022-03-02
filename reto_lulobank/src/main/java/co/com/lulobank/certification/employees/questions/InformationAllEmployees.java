package co.com.lulobank.certification.employees.questions;

import static co.com.lulobank.certification.employees.utils.enums.EnumVariablesSesion.RESPONSE_SELECT;

import co.com.lulobank.certification.employees.models.InformationEmployee;
import co.com.lulobank.certification.employees.models.ResponseSelectEmployees;
import java.util.List;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class InformationAllEmployees implements Question<Boolean> {

  public static InformationAllEmployees all() {
    return new InformationAllEmployees();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    ResponseSelectEmployees responseSelectAllEmployees =
        actor.recall(RESPONSE_SELECT.getVariableSession());

    List<InformationEmployee> employees = responseSelectAllEmployees.getData();

    return employees.size() > 1 && employees != null;
  }
}
