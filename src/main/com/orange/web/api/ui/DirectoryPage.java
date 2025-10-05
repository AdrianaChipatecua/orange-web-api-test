package com.orange.web.api.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class DirectoryPage {
  private DirectoryPage() {
  }

  public static final Target TITLE_DIRECTORY_PAGE = Target.the("title")
      .locatedBy(".oxd-text.oxd-text--h5.oxd-table-filter-title");
  public static final Target LBL_EMPLOYEE_NAME = Target.the("label employee name")
      .locatedBy("//label[normalize-space()='Employee Name']");
  public static final Target INP_EMPLOYEE_NAME = Target.the("text employee name")
      .locatedBy("//input[@placeholder='Type for hints...']");
  public static final Target DROPDOWN_OPTION = Target
      .the("Opción del autocomplete")
      .locatedBy("//div[@role='listbox']//div[normalize-space()='{0}']");
  public static final Target DROPDOWN_CONTAINER = Target.the("contenedor del dropdown")
      .located(By.xpath("//div[@role='listbox']"));
  public static final Target BTN_SEARCH = Target.the("button search").locatedBy("button[type='submit']");

  public static final Target NAME_USER_RESULT = Target.the("name user result")
      .locatedBy(".oxd-text.oxd-text--p.orangehrm-directory-card-header.--break-words");

  public static Target getDropdownOption(String name) {
    return Target.the("Opción del autocomplete")
        .locatedBy("//div[@role='listbox']//div[normalize-space()='" + name + "']");
  }

}
