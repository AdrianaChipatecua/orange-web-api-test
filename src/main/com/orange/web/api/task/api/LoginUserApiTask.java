package com.orange.web.api.task.api;

import com.orange.web.api.constans.Constants;
import com.orange.web.api.models.UserRegistrationData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class LoginUserApiTask implements Task {

  private final String endpoint;

  public LoginUserApiTask(String endpoint) {
    this.endpoint = endpoint;
  }

  public static LoginUserApiTask getLogin(String endpoint) {
    return instrumented(LoginUserApiTask.class, endpoint);
  }

  @Override
  public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {

    UserRegistrationData userRegistrationData = actor.recall(Constants.REGISTER_DATA_KEY);
    String cookie = actor.recall(Constants.SESSION_COOKIE);
    String requestBody = String.format(
        "username=%s&password=%s",
        userRegistrationData.getUserName(),
        userRegistrationData.getPassword()
    );

    actor.attemptsTo(
        Post.to(endpoint)
            .with(request -> request
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
                .header("Origin", "https://opensource-demo.orangehrmlive.com")
                .header("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/141.0.0.0 Safari/537.36")
                .header("Cookie", "orangehrm=" + cookie)
                .body(requestBody))
    );

    var responseBody = SerenityRest.lastResponse().body().asString();
    actor.remember(Constants.RESPONSE_BODY, responseBody);

    actor.should(
        seeThatResponse("Status code is 302",
            response -> response.statusCode(302)
        )
    );

  }

}