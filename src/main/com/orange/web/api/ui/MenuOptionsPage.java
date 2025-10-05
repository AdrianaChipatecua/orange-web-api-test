package com.orange.web.api.ui;

import net.serenitybdd.screenplay.targets.Target;

public class MenuOptionsPage {
    private MenuOptionsPage() {
    }

    public static Target OPT_DASHBOARD = Target.the("dashboard option").locatedBy(".oxd-main-menu-item[href='/web/index.php/dashboard/index']");
    public static Target OPT_PIM = Target.the("PIM option").locatedBy(".oxd-main-menu-item[href='/web/index.php/pim/viewPimModule']");
    public static Target OPT_DIRECTORY = Target.the("Directory option").locatedBy(".oxd-main-menu-item[href='/web/index.php/directory/viewDirectory']");

}
