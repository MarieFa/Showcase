package org.educama.acceptancetests.stepdefinitions;

import net.thucydides.core.annotations.Steps;
import org.educama.acceptancetests.steps.CustomersListSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Step definitions for the shipment list.
 */
public class CustomersListStepDefinitions extends GlobalStepDefinitions {

    @Steps
    CustomersListSteps user;


    @Given("I start to create a new customer")
    public void givenIStartToCreateANewCustomer() {
        user.openCustomersListPage();
    }

    @When("I abort the adding of a new customer")
    public void iAbortTheAddingOfANewCustomer() {
        user.addNewCustomer("Samsung", false);
    }

    @Then("There arent new customer data in the system")
    public void thereArentNewCustomerDataInTheSystem() {
        user.checksTheCustomersListData(false);
    }

    @When("I add a new customer with Samsung as customer name, Beispielstrasse as street, 1 as house number, 1234 as zip code and Seoul as city")
    public void whenIAddANewCustomer() {
        user.addNewCustomer("Samsung", true);
    }

    @Then("There are new customer data in the system")
    public void thenThereAreNewCustomerDataInTheSystem() {
        user.checksTheCustomersListData(true);
    }

    @Given("There is a customer named Apple")
    public void thereIsACustomerNamedApple() {
        user.openCustomersListPage();
    if (!user.checksTheCustomerListDataForApple()) {
        user.addNewCustomer("Apple", true);
    }
    }

    @When("I change the name Apple to Samsung and save the data")
    public void iChangeTheNameAppleToSamsungAndSaveTheData() {
        user.openAppleChangeView();
        user.changeCustomerData(true);
    }

    @Then("The name of the customer is modified")
    public void theNameOfTheCustomerIsModified() {
        user.checksTheCustomerListDataForChangedAppleToSamsung(true);
    }

    @When("I change the name Apple to Samsung and abort the action")
    public void iChangeTheNameAppleToSamsungAndAbortTheAction() {
        user.openAppleChangeView();
        user.changeCustomerData(false);
    }

    @Then("There arent any changes in the system")
    public void theraArentAnyChangesInTheSystem() {
        user.checksTheCustomerListDataForChangedAppleToSamsung(false);
    }
}
