package com.pluralsight.bddfundamentals.airport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BonusPolicy {
    @Given("we have a usual passenger with a mileage")
    public void weHaveAUsualPassengerWithAMileage() {
    }

    @When("the usual passenger travels <mileage{int}> and <mileage{int}> and <mileage{int}>")
    public void theUsualPassengerTravelsMileageAndMileageAndMileage(int arg0, int arg1, int arg2) {
    }

    @Then("the bonus points of the usual passenger should be <points>")
    public void theBonusPointsOfTheUsualPassengerShouldBePoints() {
    }
}
