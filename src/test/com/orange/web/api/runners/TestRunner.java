package com.orange.web.api.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "rerun:target/rerun.txt"},
        features = {"classpath:features"},
        tags = "@test-api",
        glue = {"com.orange.web.api.features.steps"}
)
public class TestRunner {
}
