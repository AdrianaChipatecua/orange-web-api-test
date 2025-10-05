package com.orange.web.api.abilities;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.configuration.SystemPropertiesConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import net.thucydides.model.webdriver.Configuration;

public class EnvironmentManager {
    private static final Configuration<?> CONFIGURATION =
            new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());

    private static final EnvironmentVariables environmentVariables = CONFIGURATION.getEnvironmentVariables();

    public static final String BASE_ENDPOINT =
            EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.endpoint");

}
