package co.com.lulobank.certification.employees.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/select-employee.feature",
    glue = "co.com.lulobank.certification.employees.stepdefinitions")
public class SelectEmployee {}
