package com.orange.web.api.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PimPage {
    private PimPage() {
    }

    public static Target ADD_EMPLOYEE = Target.the("add employee button")
            .located(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']"));

}
