package co.com.lulobank.certification.employees.interactions.servicios;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ConsumeServiceGetAll implements Interaction {

  private final String resource;

  public ConsumeServiceGetAll(String resource) {
    this.resource = resource;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Get.resource(resource));
  }
}
