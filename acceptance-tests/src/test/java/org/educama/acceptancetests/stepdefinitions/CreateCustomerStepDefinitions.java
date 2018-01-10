package org.educama.acceptancetests.stepdefinitions;

import net.thucydides.core.annotations.Steps;
import org.educama.acceptancetests.steps.CreateCustomerListSteps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Step Definitions to create Customer.
 */
public class CreateCustomerStepDefinitions {

    @Steps
    CreateCustomerListSteps user;

    @When("I add a new customer with $customerName as customer name, $street as street, $houseNumber as house number, $zipCode as zip code and $city as city")
    public void whenIAddANewCustomer(String customerName, String street, String houseNumber, String zipCode, String city) {
        user.createNewCustomer(customerName, street, houseNumber, zipCode, city);
    }

    @Then("There are new customer data in the system")
    public void thenThereAreNewCustomerDataInTheSystem() {
        user.checkIfCustomerWereAdded();
    }
}
