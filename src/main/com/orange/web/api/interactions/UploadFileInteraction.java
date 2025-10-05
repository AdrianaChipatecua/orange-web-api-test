package com.orange.web.api.interactions;

import com.orange.web.api.abilities.WebDriverSetUp;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.targets.Target;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UploadFileInteraction implements Interaction {
  private final String imagePath;
  private final Target targetInput;

  public UploadFileInteraction(String imagePath, Target uploadFile) {
    this.imagePath = imagePath;
    targetInput = uploadFile;
  }

  public static UploadFileInteraction photoUpload(String imagePath, Target uploadFile) {
    return instrumented(UploadFileInteraction.class, imagePath, uploadFile);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    var driver = WebDriverSetUp.webDriver(actor);

    driver.executeScript(
        "arguments[0].style.display='block';",
        targetInput.resolveFor(actor)
    );
    actor.attemptsTo(
        Upload.theFile(Paths.get(imagePath))
            .to(targetInput)
    );

  }
}
