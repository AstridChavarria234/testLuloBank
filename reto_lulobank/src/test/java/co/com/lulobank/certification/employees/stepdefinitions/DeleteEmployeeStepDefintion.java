package co.com.lulobank.certification.employees.stepdefinitions;

import static co.com.lulobank.certification.employees.exceptions.CodeResponseServiceFail.CODE_RESPONSE_SERVICE;
import static co.com.lulobank.certification.employees.exceptions.DeleteFail.DELETE_FAIL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.lulobank.certification.employees.exceptions.CodeResponseServiceFail;
import co.com.lulobank.certification.employees.exceptions.DeleteFail;
import co.com.lulobank.certification.employees.questions.CodeResponseService;
import co.com.lulobank.certification.employees.questions.InformationAnEmployee;
import co.com.lulobank.certification.employees.tasks.DeleteEmployee;
import co.com.lulobank.certification.employees.tasks.SelectAnEmployee;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import org.apache.http.HttpStatus;

public class DeleteEmployeeStepDefintion {

  @When("removal of the person is done")
  public void deleteEmployee(Map<String, String> employeeInformation) {

    theActorInTheSpotlight()
        .attemptsTo(DeleteEmployee.byId(employeeInformation.get("id_employee")));

    theActorInTheSpotlight()
        .attemptsTo(SelectAnEmployee.byId(employeeInformation.get("id_employee")));
  }

  @Then("it should indicate that the deletion was successful")
  public void validateEmployeeRemoval() {

    theActorInTheSpotlight()
        .should(
            seeThat(CodeResponseService.get(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(CodeResponseServiceFail.class, CODE_RESPONSE_SERVICE));

    theActorInTheSpotlight()
        .should(
            seeThat(InformationAnEmployee.validateDelete(true))
                .orComplainWith(DeleteFail.class, DELETE_FAIL));
  }
}
