package com.orange.web.api.abilities;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.orange.web.api.exceptions.NotFoundUserAbility;
import com.orange.web.api.exceptions.NotFoundWebdriver;

public class WebDriverSetUp extends BrowseTheWeb {


    protected WebDriverSetUp(WebDriver browser) {
        super(browser);
    }

    @Override
    public String toString() {
        return "Use a web driver";
    }

    private ChromeDriver getChromeDriver() {
        WebDriver proxiedDriver = ((WebDriverFacade) getDriver()).getProxiedDriver();
        if (proxiedDriver instanceof ChromeDriver) {
            return (ChromeDriver) proxiedDriver;
        } else {
            throw new NotFoundUserAbility();
        }
    }

    public static WebDriverSetUp likeActor(Actor actor) {
        WebDriverSetUp ability = actor.abilityTo(WebDriverSetUp.class);
        if (ability != null) {
            return ability.asActor(actor);
        } else {
            throw new NotFoundWebdriver();
        }
    }

    public static ChromeDriver webDriver(Actor actor) {
        return likeActor(actor).getChromeDriver();
    }

    public static WebDriverSetUp with(WebDriver driver) {
        return new WebDriverSetUp(driver);
    }
}