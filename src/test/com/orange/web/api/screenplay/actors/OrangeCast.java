package com.orange.web.api.screenplay.actors;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import com.orange.web.api.abilities.EnvironmentManager;
import com.orange.web.api.abilities.WebDriverSetUp;

public class OrangeCast extends Cast {

    public EnvironmentVariables environmentVariables;

    public OrangeCast(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        return super.actorNamed(actorName,
                WebDriverSetUp.with(theDefaultDriverFor(actorName)),
                CallAnApi.at(EnvironmentManager.BASE_ENDPOINT),
                BrowseTheWeb.with(theDefaultDriverFor(actorName))
        );
    }

    private WebDriver theDefaultDriverFor(String actorName) {
        return ThucydidesWebDriverSupport.getWebdriverManager().getWebdriverByName(actorName);
    }
}
