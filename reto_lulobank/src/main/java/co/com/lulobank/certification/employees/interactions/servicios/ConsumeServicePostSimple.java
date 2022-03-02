package co.com.lulobank.certification.employees.interactions.servicios;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ConsumeServicePostSimple implements Interaction {

  private final String resource;
  private final Object request;

  public ConsumeServicePostSimple(String resource, Object request) {
    this.resource = resource;
    this.request = request;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to(resource)
            .with(
                requestSpecification ->
                    requestSpecification.contentType(ContentType.JSON).body(request)));
  }
}
