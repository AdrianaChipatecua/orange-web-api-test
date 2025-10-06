package com.orange.web.api.task.api;

import com.orange.web.api.constans.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.regex.Pattern;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TokenExtractTask implements Task {

  public static TokenExtractTask getToken() {
    return instrumented(TokenExtractTask.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.resource("/auth/login")
    );

    var htmlResponse = SerenityRest.lastResponse().body().asString();
    Pattern pattern = Pattern.compile(":token\\s*=\\s*\"&quot;([^\"]+)&quot;\"", Pattern.DOTALL);
    var htmlValue = pattern.matcher(htmlResponse);
    var sessionCookie = SerenityRest.lastResponse().getCookie("orangehrm");
    actor.remember(Constants.SESSION_COOKIE, sessionCookie);

    if (htmlValue.find()) {
      String token = htmlValue.group(1);
      actor.remember(Constants.TOKEN_API, token);
    } else {
      System.out.println("No se encontró token");
    }
  }
}

