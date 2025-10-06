package com.orange.web.api.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateEmployeePimOptionPage {
    private CreateEmployeePimOptionPage() {
    }

    public static Target INP_FIRST_NAME = Target.the("input first name")
            .located(By.cssSelector("input[name='firstName']"));
    public static Target INP_LAST_NAME = Target.the("input first name")
            .locatedBy(".oxd-input--active[name='lastName']");
    public static Target INP_MIDDLE_NAME = Target.the("input middle name")
            .locatedBy(".oxd-input.oxd-input--active[name='middleName']");
    public static Target OPT_SWITCH_LOGIN_DETAILS = Target.the("input last name")
            .locatedBy(".oxd-switch-input");
    public static Target INP_EMPLOYEE_ID = Target.the("input employee id")
            .locatedBy("(//input[@class='oxd-input oxd-input--active'])[2]");
    public static Target INP_USER_NAME = Target.the("input user name")
            .locatedBy("(//input[@autocomplete='off'])[1]");
    public static Target INP_PASSWORD = Target.the("input password")
            .locatedBy("(//input[@type='password'])[1]");
    public static Target INP_CONFIRM_PASSWORD = Target.the("input confirm password")
            .locatedBy("(//input[@type='password'])[2]");
    public static Target BTN_SAVE_EMPLOYEE = Target.the("button save")
            .located(By.cssSelector("button[type='submit']"));
    public static Target IMG_PHOTO_UPLOAD = Target.the("campo para subir la foto" )
            .locatedBy("//input[@type='file' and contains(@class,'oxd-file-input')]");

}
