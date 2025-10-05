package com.orange.web.api.task;


import com.orange.web.api.constans.CreateUserConstants;
import com.orange.web.api.interactions.UploadFileInteraction;
import com.orange.web.api.ui.CreateEmployeePimOptionPage;
import com.orange.web.api.ui.PimPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.concurrent.ThreadLocalRandom;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class CreateEmployeeTask implements Task {

  private final String firstName;
  private final String lastName;
  private final String password;

  public CreateEmployeeTask(String firstName, String lastName, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
  }

  public static CreateEmployeeTask withData(String firstName, String lastName, String password) {
    return instrumented(CreateEmployeeTask.class, firstName, lastName, password);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String imagePath = "images/profile.jpg";
    int randomNumber = generateRandomNumber();

    String uniqueFirstName = firstName + randomNumber;
    String uniqueLastName = lastName + randomNumber;
    String username = firstName + lastName + randomNumber;



    actor.attemptsTo(
        WaitUntil.the(PimPage.ADD_EMPLOYEE, isEnabled())
            .forNoMoreThan(10).seconds(),
        Click.on(PimPage.ADD_EMPLOYEE).afterWaitingUntilEnabled(),
        WaitUntil.the(CreateEmployeePimOptionPage.INP_FIRST_NAME, isEnabled())
            .forNoMoreThan(15).seconds(),
        Enter.theValue(uniqueFirstName).into(CreateEmployeePimOptionPage.INP_FIRST_NAME),
        Enter.theValue(uniqueLastName).into(CreateEmployeePimOptionPage.INP_LAST_NAME),
        Enter.theValue(String.valueOf(randomNumber)).into(CreateEmployeePimOptionPage.INP_EMPLOYEE_ID),
        Click.on(CreateEmployeePimOptionPage.OPT_SWITCH_LOGIN_DETAILS),
        Enter.theValue(username).into(CreateEmployeePimOptionPage.INP_USER_NAME),
        Enter.theValue(password).into(CreateEmployeePimOptionPage.INP_PASSWORD),
        Enter.theValue(password).into(CreateEmployeePimOptionPage.INP_CONFIRM_PASSWORD),
        UploadFileInteraction.photoUpload(imagePath, CreateEmployeePimOptionPage.IMG_PHOTO_UPLOAD),
        Click.on(CreateEmployeePimOptionPage.BTN_SAVE_EMPLOYEE)
    );

    actor.remember(CreateUserConstants.USER_NAME, username);
    actor.remember(CreateUserConstants.FIRST_NAME, uniqueFirstName);
    actor.remember(CreateUserConstants.LAST_NAME, uniqueLastName);
    actor.remember(CreateUserConstants.EMPLOYEE_ID, String.valueOf(randomNumber));

  }

  private int generateRandomNumber() {
    return ThreadLocalRandom.current().nextInt(1, 100);
  }

}
