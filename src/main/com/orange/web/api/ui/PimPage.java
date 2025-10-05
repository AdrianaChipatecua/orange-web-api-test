package com.orange.web.api.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PimPage {
    private PimPage() {
    }

    public static Target ADD_EMPLOYEE = Target.the("add employee button")
            .locatedBy("//button[normalize-space()='Add']");

}
