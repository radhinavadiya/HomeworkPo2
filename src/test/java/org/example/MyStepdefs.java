package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    RegisterResult registerResult = new RegisterResult();
    RegistrationDetails registrationDetails = new RegistrationDetails();

    @Given("I am on registration page")
    public void i_am_on_registration_page() {
        homePage.clickOnRegisterButton();

    }
    @When("I enter required registraion details")
    public void i_enter_required_registraion_details() {
        registrationDetails.EnterRegistrationDetails();
    }
    @Then("I should able to register successfully")
    public void i_should_able_to_register_successfully() {
        registerResult.registerSuccess();

    }
}
