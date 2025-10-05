package com.orange.web.api.questions;

import com.orange.web.api.constans.CreateUserConstants;
import com.orange.web.api.interactions.PauseInteractions;
import com.orange.web.api.ui.PersonalDetailsPage;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateEmployeeDataQuestions {

  public static void validateEmployeeData() {
    var actor = OnStage.theActorInTheSpotlight();

    String firstName = actor.recall(CreateUserConstants.FIRST_NAME);
    String lastName = actor.recall(CreateUserConstants.LAST_NAME);

    String firstNameInput = PersonalDetailsPage.FIRST_NAME_INPUT.resolveFor(actor).getTextContent();
    String lastNameInput = PersonalDetailsPage.LAST_NAME_INPUT.resolveFor(actor).getTextContent();

    System.out.println("input"+firstNameInput);
    System.out.println("input"+lastNameInput);
    System.out.println(firstName);
    System.out.println(lastName);

    OnStage.withCurrentActor(
        WaitUntil.the(PersonalDetailsPage.FIRST_NAME_INPUT, isVisible())
            .forNoMoreThan(10).seconds(),
        PauseInteractions.withDuration(8)
    );

    CommonQuestions.textEqualsString(firstNameInput, firstName);
    CommonQuestions.textEqualsString(lastNameInput, lastName);
  }
}