package com.orange.web.api.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    private LoginPage() {
    }
    public static Target IMG_BRANDING = Target.the("Logo image in login page")
            .located(By.cssSelector(".orangehrm-login-branding [alt='company-branding']"));

    public static Target INP_USERNAME = Target.the("User input in login page")
            .located(By.cssSelector("[name='username']"));

    public static Target INP_PASSWORD = Target.the("Password input in login page")
            .located(By.cssSelector("[name='password']"));

    public static Target LOGIN_BUTTON = Target.the("Login button in login page")
            .located(By.cssSelector("button[type='submit']"));

}
