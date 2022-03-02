package co.com.lulobank.certification.employees.interactions.servicios;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ConsumeServiceGetById implements Interaction {

  private final String resource;
  private final String id;

  public ConsumeServiceGetById(String resource, String id) {
    this.resource = resource;
    this.id = id;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(Get.resource(resource).with(request -> request.pathParam("id", id)));
  }
}
