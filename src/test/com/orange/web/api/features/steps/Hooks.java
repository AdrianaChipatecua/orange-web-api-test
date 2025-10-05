package com.orange.web.api.features.steps;

import io.cucumber.java.Before;

import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.model.util.EnvironmentVariables;

import com.orange.web.api.screenplay.actors.OrangeCast;


public class Hooks {
    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OrangeCast(environmentVariables));
    }
}
