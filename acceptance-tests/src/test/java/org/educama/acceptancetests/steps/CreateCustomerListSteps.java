package org.educama.acceptancetests.steps;

import com.jayway.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Step;
import org.educama.customer.model.Address;
import org.educama.customer.model.Customer;

import org.junit.Assert;

/**
 * List Steps to create Customer.
 */
public class CreateCustomerListSteps {

    private static final String RESTURI = "http://localhost:8091/educama/v1/customers";
    private static final int EXPECTEDCREATEDSTATUS = 201;
    private static final int EXPECTEDOKSTATUS = 200;
    private String uuid;

    @Step
    public void createNewCustomer(String customerName, String street, String houseNumber, String zipCode, String city) {

        Customer customer = new Customer(
                customerName, new Address(street, houseNumber, zipCode, city));

        Response responsePost = SerenityRest.given().contentType("application/json")
                .content(customer).and().expect().that().statusCode(EXPECTEDCREATEDSTATUS)
                .when().post(RESTURI).andReturn();
        uuid = responsePost.body().jsonPath().get("uuid");
        responsePost.body().prettyPrint();

    }

    @Step
    public void checkIfCustomerWereAdded() {

        String getCustomerByUuid = RESTURI + "/" + uuid;

        Response responseGet = SerenityRest.expect().that().statusCode(EXPECTEDOKSTATUS)
                .get(getCustomerByUuid).andReturn();
        String uuid2 = responseGet.body().jsonPath().get("uuid");
        Assert.assertEquals(uuid, uuid2);
    }

}
