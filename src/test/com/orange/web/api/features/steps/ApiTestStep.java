package com.orange.web.api.features.steps;

import com.orange.web.api.constans.Constants;
import com.orange.web.api.task.api.LoginUserApiTask;
import com.orange.web.api.task.api.TokenExtractTask;
import com.orange.web.api.utils.DataManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ApiTestStep {

  @Given("{word} inicia la conexion a la API para obtener un token de autenticacion")
  public void startApiConnection(String actorName) {
    OnStage
        .theActorCalled(actorName)
        .describedAs("User connect to api");
    DataManager.initActorWithName(actorName);
    OnStage.withCurrentActor(TokenExtractTask.getToken());
  }

  @When("el/El/ella/Ella realiza la peticion al request {string}")
  public void makeRequest(String endpoint) {
    OnStage.withCurrentActor(
        LoginUserApiTask.getLogin(endpoint));
  }

  @Then("podra ver el mensaje de redireccion exitosa")
  public void seeSuccessfulRedirectionMessage() {
    var actor = OnStage.theActorInTheSpotlight();
    Object recalledObject = actor.recall(Constants.RESPONSE_BODY);
    String responseBody = recalledObject != null ? recalledObject.toString() : "";

    actor.should(
        seeThat("Response body contains redirect URL",
            r -> responseBody.contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
        )
    );
  }
}
