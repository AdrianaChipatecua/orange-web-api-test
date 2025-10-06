package com.orange.web.api.features.steps;

import com.orange.web.api.questions.CommonQuestions;
import com.orange.web.api.task.LoginTask;
import com.orange.web.api.ui.TopBarPage;
import com.orange.web.api.utils.DataManager;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;

public class LoginStep {


  @Given("{word} incia sesion en la plataforma de OrangeHRM")
  public void loginIntoOrangePlatform(String actorName) {
    System.out.println("El actor " + actorName + " ingresa a la plataforma de OrangeHRM");
    OnStage.theActorCalled(actorName)
        .describedAs("User Open Web site");
    DataManager.initActorWithName(actorName);
    var actor = OnStage.theActorInTheSpotlight();
    OnStage.withCurrentActor(
        LoginTask.writeData(actor)
    );
    CommonQuestions.elementIsPresent(TopBarPage.TITLE_DASHBOARD);
  }

}
