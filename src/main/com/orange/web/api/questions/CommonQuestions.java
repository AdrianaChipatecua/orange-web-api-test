package com.orange.web.api.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.StaleElementReferenceException;

import com.orange.web.api.constans.Constants;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CommonQuestions {

    private CommonQuestions() {
    }

    public static void textEqualsTarget(Target target, String label) {
        OnStage.theActorInTheSpotlight()
                .should(
                        eventually(
                                seeThat(
                                        TheTarget.textOf(target), CoreMatchers.containsStringIgnoringCase(label)))
                                .waitingForNoLongerThan(Constants.WAIT_LONG_SECONDS)
                                .seconds());
    }

    public static void elementIsPresent(Target target) {
        OnStage.theActorInTheSpotlight()
                .should(
                        eventually(
                                seeThat(
                                        Visibility.of(target)))
                                .waitingForNoLongerThan(Constants.WAIT_TIME).seconds());
    }

    public static void elementIsNotPresent(Target target) {
        OnStage.theActorInTheSpotlight()
                .should(
                        eventually(seeThat(Question.not(
                                Visibility.of(target)))));
    }

    @SuppressWarnings("unchecked")
    public static void tryElementIsPresent(Target target, int wait) {
        OnStage.theActorInTheSpotlight().can(
                eventually(seeThat(Presence.of(target))).waitingForNoLongerThan(wait).seconds()
                        .ignoringExceptions(AssertionError.class, StaleElementReferenceException.class));
    }

    public static void textEqualsString(String expected, String actual) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("The values are equals", actor -> expected.equals(actual)));
    }
}
