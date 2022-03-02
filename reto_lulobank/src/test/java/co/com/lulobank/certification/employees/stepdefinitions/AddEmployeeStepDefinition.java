package co.com.lulobank.certification.employees.stepdefinitions;

import static co.com.lulobank.certification.employees.exceptions.CodeResponseServiceFail.CODE_RESPONSE_SERVICE;
import static co.com.lulobank.certification.employees.exceptions.SelectFail.SELECT_FAIL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.lulobank.certification.employees.exceptions.CodeResponseServiceFail;
import co.com.lulobank.certification.employees.exceptions.SelectFail;
import co.com.lulobank.certification.employees.questions.CodeResponseService;
import co.com.lulobank.certification.employees.questions.InformationAnEmployee;
import co.com.lulobank.certification.employees.questions.MessageAddEmployee;
import co.com.lulobank.certification.employees.tasks.AddEmployee;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import org.apache.http.HttpStatus;

public class AddEmployeeStepDefinition {

  @When("Add the employee")
  public void addTheEmployee(Map<String, String> employeeInformation) {

    theActorInTheSpotlight().attemptsTo(AddEmployee.information(employeeInformation));
  }

  @Then("personal information should be displayed of the added employee")
  public void validateAddEmployee() {
    theActorInTheSpotlight()
        .should(
            seeThat(CodeResponseService.get(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(CodeResponseServiceFail.class, CODE_RESPONSE_SERVICE));

    theActorInTheSpotlight()
        .should(
            seeThat(InformationAnEmployee.validateDelete(false))
                .orComplainWith(SelectFail.class, SELECT_FAIL));

    theActorInTheSpotlight().should(seeThat(MessageAddEmployee.validateAdd()));
  }
}
