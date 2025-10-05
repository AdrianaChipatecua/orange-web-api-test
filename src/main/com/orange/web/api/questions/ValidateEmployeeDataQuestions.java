package com.orange.web.api.questions;

import com.orange.web.api.constans.CreateUserConstants;
import com.orange.web.api.interactions.PauseInteractions;
import com.orange.web.api.ui.PersonalDetailsPage;
import net.serenitybdd.screenplay.actors.OnStage;

public class ValidateEmployeeDataQuestions {

  public static void validateEmployeeData() {
    var actor = OnStage.theActorInTheSpotlight();

    String firstName = actor.recall(CreateUserConstants.FIRST_NAME);
    String lastName = actor.recall(CreateUserConstants.LAST_NAME);

    actor.attemptsTo(
        PauseInteractions.withDuration(3)
    );
    String firstNameInput = PersonalDetailsPage.FIRST_NAME_INPUT.resolveFor(actor).getValue();
    String lastNameInput = PersonalDetailsPage.LAST_NAME_INPUT.resolveFor(actor).getValue();

    CommonQuestions.textEqualsString(firstNameInput, firstName);
    CommonQuestions.textEqualsString(lastNameInput, lastName);
  }
}