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


  @Override
  public <T extends Actor> void performAs(T actor) {
    String userName = actor.recall(CreateUserConstants.USER_NAME);
    String employeeId = actor.recall(CreateUserConstants.EMPLOYEE_ID);
    String employeeName = actor.recall(CreateUserConstants.FIRST_NAME+" "+CreateUserConstants.LAST_NAME);


    CommonQuestions.elementIsPresent(DirectoryPage.TITLE_DIRECTORY_PAGE);
    CommonQuestions.elementIsPresent(DirectoryPage.LBL_EMPLOYEE_NAME);

    actor.attemptsTo(
        Enter.theValue(employeeName).into(DirectoryPage.INP_EMPLOYEE_NAME),
        WaitUntil.the(DirectoryPage.DROPDOWN_CONTAINER, isVisible())
            .forNoMoreThan(5).seconds(),
        Click.on(DirectoryPage.DROPDOWN_OPTION.of(employeeName))
    );
  }

  public static SearchEmployeeTask validateNewEmployee() {
    return instrumented(SearchEmployeeTask.class);
  }
}
