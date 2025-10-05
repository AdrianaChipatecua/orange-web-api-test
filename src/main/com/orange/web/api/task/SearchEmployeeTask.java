package com.orange.web.api.task;

import com.orange.web.api.constans.CreateUserConstants;
import com.orange.web.api.questions.CommonQuestions;
import com.orange.web.api.ui.DirectoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchEmployeeTask implements Task {


  public static SearchEmployeeTask validateNewEmployee() {
    return instrumented(SearchEmployeeTask.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String firstName = actor.recall(CreateUserConstants.FIRST_NAME);
    String lastName = actor.recall(CreateUserConstants.LAST_NAME);
    String employeeFullName = firstName + " " + lastName;

    CommonQuestions.elementIsPresent(DirectoryPage.TITLE_DIRECTORY_PAGE);
    CommonQuestions.elementIsPresent(DirectoryPage.LBL_EMPLOYEE_NAME);

    actor.attemptsTo(
        Enter.theValue(firstName).into(DirectoryPage.INP_EMPLOYEE_NAME),
        WaitUntil.the(DirectoryPage.DROPDOWN_CONTAINER, isVisible())
            .forNoMoreThan(15).seconds(),
        WaitUntil.the(DirectoryPage.getDropdownOption(employeeFullName), isVisible()).forNoMoreThan(15).seconds(),
        Click.on(DirectoryPage.getDropdownOption(employeeFullName)),
        WaitUntil.the((DirectoryPage.BTN_SEARCH),isVisible()).forNoMoreThan(8).seconds(),
        Click.on(DirectoryPage.BTN_SEARCH),
        WaitUntil.the((DirectoryPage.NAME_USER_RESULT), isVisible()).forNoMoreThan(8).seconds()
    );
    CommonQuestions.textEqualsTarget(DirectoryPage.NAME_USER_RESULT, employeeFullName);
  }
}
