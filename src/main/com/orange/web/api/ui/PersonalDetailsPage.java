package com.orange.web.api.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PersonalDetailsPage {
  private PersonalDetailsPage() {
  }

  public static final Target TITLE_PERSONAL_DETAILS = Target.the("title personal details")
      .locatedBy("(//h6[normalize-space()='Personal Details'])[1]");
  public static final Target CARD_PERSONAL_DETAILS_OPTIONS = Target.the("menu options employee navigation")
      .locatedBy(".orangehrm-edit-employee-navigation");
  public static final Target FIRST_NAME_INPUT = Target.the("first name input")
      .located(By.cssSelector(".oxd-input--active[name='firstName'][xpath='1']"));
  public static final Target LAST_NAME_INPUT = Target.the("last name input")
      .located(By.cssSelector(".oxd-input--active[name='lastName'][xpath='1']"));
}
