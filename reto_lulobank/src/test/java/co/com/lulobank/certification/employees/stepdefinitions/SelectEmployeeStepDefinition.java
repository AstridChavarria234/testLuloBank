package co.com.lulobank.certification.employees.stepdefinitions;

import static co.com.lulobank.certification.employees.exceptions.CodeResponseServiceFail.CODE_RESPONSE_SERVICE;
import static co.com.lulobank.certification.employees.exceptions.SelectFail.SELECT_FAIL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.lulobank.certification.employees.exceptions.CodeResponseServiceFail;
import co.com.lulobank.certification.employees.exceptions.SelectFail;
import co.com.lulobank.certification.employees.questions.CodeResponseService;
import co.com.lulobank.certification.employees.questions.InformationAllEmployees;
import co.com.lulobank.certification.employees.questions.InformationAnEmployee;
import co.com.lulobank.certification.employees.tasks.SelectAnEmployee;
import co.com.lulobank.certification.employees.tasks.SelectEmployees;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import org.apache.http.HttpStatus;

public class SelectEmployeeStepDefinition {

  @When("Select the employee")
  public void selectTheEmployee(Map<String, String> employeeInformation) {
    theActorInTheSpotlight()
        .attemptsTo(SelectAnEmployee.byId(employeeInformation.get("id_employee")));
  }

  @When("Select the employees")
  public void selectTheEmployees() {
    theActorInTheSpotlight().attemptsTo(SelectEmployees.all());
  }

  @Then("personal information should be displayed")
  public void validateInformationPersonal() {
    theActorInTheSpotlight()
        .should(
            seeThat(CodeResponseService.get(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(CodeResponseServiceFail.class, CODE_RESPONSE_SERVICE));

    theActorInTheSpotlight()
        .should(
            seeThat(InformationAnEmployee.validateDelete(false))
                .orComplainWith(SelectFail.class, SELECT_FAIL));
  }

  @Then("personal information should be displayed for all employees")
  public void validateInformationPersonalAllEmployees() {

    theActorInTheSpotlight()
        .should(
            seeThat(CodeResponseService.get(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(CodeResponseServiceFail.class, CODE_RESPONSE_SERVICE));

    theActorInTheSpotlight()
        .should(
            seeThat(InformationAllEmployees.all()).orComplainWith(SelectFail.class, SELECT_FAIL));
  }
}
