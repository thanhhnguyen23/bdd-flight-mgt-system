package com.pluralsight.bddfundamentals.airport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusPolicy {
    private Passenger mike;
    private Mileage mileage;

    @Given("we have a usual passenger with a mileage")
    public void weHaveAUsualPassengerWithAMileage() {
        mike = new Passenger("Mike", false);
        mileage = new Mileage();
    }

    @When("the usual passenger travels <mileage{int}> and <mileage{int}> and <mileage{int}>")
    public void theUsualPassengerTravelsMileageAndMileageAndMileage(int mileage1, int mileage2, int mileage3) {
        mileage.addMileage(mike, mileage1);
        mileage.addMileage(mike, mileage2);
        mileage.addMileage(mike, mileage3);
    }

    @Then("the bonus points of the usual passenger should be <points>")
    public void theBonusPointsOfTheUsualPassengerShouldBePoints(int points) {
        mileage.calculateGivenPoints();
        assertEquals(points, mileage.getPassengersPointsMap().get(0));
    }
}
