package com.orange.web.api.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PersonalDetailsPage {
  private PersonalDetailsPage() {
  }

  public static final Target TITLE_PERSONAL_DETAILS = Target.the("title personal details")
      .locatedBy("(//h6[normalize-space()='Personal Details'])[1]");
  public static final Target CARD_PERSONAL_DETAILS_OPTIONS = Target.the("menu options employee navigation")
      .locatedBy(".orangehrm-edit-employee-navigation");
  public static final Target FIRST_NAME_INPUT = Target.the("first name input")
      .locatedBy("(//input[@placeholder='First Name'])[1]");
  public static final Target LAST_NAME_INPUT = Target.the("last name input")
      .locatedBy("(//input[@placeholder='Last Name'])[1]");
}
