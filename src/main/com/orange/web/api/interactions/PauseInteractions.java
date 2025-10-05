package com.orange.web.api.interactions;

import com.orange.web.api.abilities.WebDriverSetUp;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class PauseInteractions implements Interaction, IsHidden {

  private final int duration;

  public PauseInteractions(int duration) {
    this.duration = duration;
  }

  public static Interaction withDuration(int duration) {
    return new PauseInteractions(duration);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    WebDriverSetUp.likeActor(actor).waitFor(duration).seconds();
  }
}
