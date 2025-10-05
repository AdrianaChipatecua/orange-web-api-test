package com.orange.web.api.task;

import com.orange.web.api.constans.Constants;
import com.orange.web.api.questions.CommonQuestions;
import com.orange.web.api.ui.LoginPage;
import com.orange.web.api.ui.TopBarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

  public static LoginTask writeData(Actor actor) {
    return instrumented(LoginTask.class, actor);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Open.url(Constants.WEB_URL)
    );
    CommonQuestions.tryElementIsPresent(LoginPage.IMG_BRANDING, Constants.WAIT_TIME);
    actor.attemptsTo(
        Enter.theValue(Constants.SUCCESSFUL_USER_NAME).into(LoginPage.INP_USERNAME),
        Enter.theValue(Constants.SUCCESSFUL_PASSWORD).into(LoginPage.INP_PASSWORD),
        Click.on(LoginPage.LOGIN_BUTTON),
        WaitUntil.the((TopBarPage.TITLE_DASHBOARD), isVisible()).forNoMoreThan(Constants.WAIT_TIME).seconds());
  }
}
