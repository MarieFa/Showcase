package org.educama.acceptancetests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

import org.openqa.selenium.WebElement;
/**
 *
 * Page (see "Page Object Pattern") for editing a customer.
 *
 */
@DefaultUrl("http://localhost/customers/edit")
@NamedUrls(
        {
          @NamedUrl(name = "open.issue", url = "http://localhost:8090/customers/edit/{0}")
        }
      )
public class CustomerEditPage extends PageObject {
    PageObject page;

    @FindBy(id = "customer-capture-component_customer-name")
    WebElement formFieldCustomerName;

    @FindBy(id = "customer-capture-component_save-button")
    WebElement saveButton;

    public void openCustomerChangePage(String id) {
        page.open("open.issue", withParameters(id));
    }

    public void changeCustomerName() {
        formFieldCustomerName.sendKeys("Samsung");
        clickOn(saveButton);
    }
}
