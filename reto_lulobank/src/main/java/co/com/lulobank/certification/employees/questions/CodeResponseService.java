package co.com.lulobank.certification.employees.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodeResponseService implements Question<Integer> {
  public static CodeResponseService get() {
    return new CodeResponseService();
  }

  @Override
  public Integer answeredBy(Actor actor) {
    return SerenityRest.lastResponse().statusCode();
  }
}
