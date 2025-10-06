package com.orange.web.api.features.steps;

import com.orange.web.api.questions.CommonQuestions;
import com.orange.web.api.questions.ValidateEmployeeDataQuestions;
import com.orange.web.api.task.CreateEmployeeTask;
import com.orange.web.api.task.SearchEmployeeTask;
import com.orange.web.api.task.common.NavigateMenuTask;
import com.orange.web.api.ui.PersonalDetailsPage;
import com.orange.web.api.ui.TopBarPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EmployeeCreationStep {

  @When("agrega un nuevo empleado desde la opcion del menu {string}")
  public void addNewEmployee(String menuOption) {
    OnStage.withCurrentActor(
        NavigateMenuTask.to(menuOption));
    CommonQuestions.elementIsPresent(TopBarPage.TITLE_DASHBOARD);
    OnStage.withCurrentActor(
        CreateEmployeeTask.withData("Test", "Automation", "Ta123456"),
        WaitUntil.the(PersonalDetailsPage.CARD_PERSONAL_DETAILS_OPTIONS, isVisible()).forNoMoreThan(20).seconds()
    );
  }

  @Then("podra buscar el empleado agregado desde la opcion {string}")
  public void shouldSeeTheAddedEmployeeInTheDirectoryList(String menuOption) {
    OnStage.withCurrentActor(
        NavigateMenuTask.to(menuOption)
    );
    CommonQuestions.elementIsPresent(TopBarPage.TITLE_DASHBOARD);
    OnStage.withCurrentActor(
        SearchEmployeeTask.validateNewEmployee()
    );


  }
}
