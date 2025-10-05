package com.orange.web.api.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TopBarPage {
    private TopBarPage() {
    }

    public static Target TITLE_DASHBOARD = Target.the("top bar title")
            .located(By.cssSelector(".oxd-topbar-header-title"));


}
