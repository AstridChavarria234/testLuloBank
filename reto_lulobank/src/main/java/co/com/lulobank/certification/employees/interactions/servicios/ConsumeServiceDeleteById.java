package co.com.lulobank.certification.employees.interactions.servicios;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class ConsumeServiceDeleteById implements Interaction {

  private final String resource;
  private final String id;

  public ConsumeServiceDeleteById(String resource, String id) {
    this.resource = resource;
    this.id = id;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Delete.from(String.format(resource, id)));
  }
}
