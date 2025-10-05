package com.orange.web.api.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PersonalDetailsPage {
  private PersonalDetailsPage() {
  }

  public static final Target TITLE_PERSONAL_DETAILS = Target.the("title personal details")
      .locatedBy("(//h6[normalize-space()='Personal Details'])[1]");
  public static final Target CARD_PERSONAL_DETAILS_OPTIONS = Target.the("menu options employee navigation")
      .locatedBy(".orangehrm-edit-employee-navigation");
}
