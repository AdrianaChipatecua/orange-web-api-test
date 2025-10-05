package com.orange.web.api.features.steps;

import com.orange.web.api.questions.CommonQuestions;
import com.orange.web.api.task.CreateEmployeeTask;
import com.orange.web.api.task.SearchEmployeeTask;
import com.orange.web.api.task.common.NavigateMenuTask;
import com.orange.web.api.ui.TopBarPage;
import com.orange.web.api.ui.PersonalDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EmployeeCreationStep {

    @When("agrega un nuevo empleado desde la opcion del menu {string}")
    public void addNewEmployee(String menuOption) {
        OnStage.withCurrentActor(
                NavigateMenuTask.to(menuOption));
        CommonQuestions.textEqualsTarget(TopBarPage.TITLE_DASHBOARD, menuOption);
        OnStage.withCurrentActor(
                CreateEmployeeTask.withData("Test", "Automation", "Ta123456"),
            WaitUntil.the(PersonalDetailsPage.CARD_PERSONAL_DETAILS_OPTIONS, isEnabled()).forNoMoreThan(15).seconds()
        );
        CommonQuestions.elementIsPresent(PersonalDetailsPage.CARD_PERSONAL_DETAILS_OPTIONS);

    }

    @Then("podra buscar el empleado agregado desde la opcion {string}")
    public void shouldSeeTheAddedEmployeeInTheDirectoryList(String menuOption) {
        OnStage.withCurrentActor(
                NavigateMenuTask.to(menuOption)
        );
        CommonQuestions.textEqualsTarget(TopBarPage.TITLE_DASHBOARD, menuOption);
        OnStage.withCurrentActor(
               SearchEmployeeTask.validateNewEmployee()
        );


    }
}
