package com.pluralsight.bddfundamentals.airport;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengersPolicy {

    private Flight economyFlight;
    private Flight businessFlight;
    private Flight premiumFlight;
    private Passenger mike;
    private Passenger john;

    @Given("there is an economy flight")
    public void thereIsAnEconomyFlight() {
        economyFlight = new EconomyFlight("1");
    }

    @Given("there is a business flight")
    public void thereIsABusinessFlight() {
        businessFlight = new BusinessFlight("2");
    }

    @Given("there is a premium flight")
    public void thereIsAPremiumFlight() {
        premiumFlight = new PremiumFlight("3");
    }

    //--------------------------------------------------------------------------------

    @When("we have a usual passenger")
    public void weHaveAUsualPassenger() {
        mike = new Passenger("Mike", false);
    }

    @When("we have a VIP passenger")
    public void weHaveAVIPPassenger() {
        john = new Passenger("John", true);
    }

    //--------------------------------------------------------------------------------

    @Then("you can add and remove him from an economy flight")
    public void youCanAddAndRemoveHimFromAnEconomyFlight() {

        assertAll("Verify all conditions for a usual passenger in an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(mike)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("Mike", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(true, economyFlight.removePassenger(mike)),
                () -> assertEquals(0, economyFlight.getPassengersList().size())
        );
    }

    @Then("you can add him but cannot remove him from an economy flight")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyFlight() {

        assertAll("Verify all conditions for a VIP passenger in an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(john)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("John", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(false, economyFlight.removePassenger(john)),
                () -> assertEquals(1, economyFlight.getPassengersList().size())
        );
    }

    //--------------------------------------------------------------------------------

    @Then("you cannot add or remove him from a business flight")
    public void youCannotAddOrRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a usual passenger on a business flight",
                () -> assertEquals(false, businessFlight.addPassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengersList().size())
        );
    }

    @Then("you can add him but cannot remove him from a business flight")
    public void youCanAddHimButCannotRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a VIP passenger in a business flight",
                () -> assertEquals(true, businessFlight.addPassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengersList().size())
        );
    }

    //--------------------------------------------------------------------------------

    @Then("you cannot add or remove him from a premium flight")
    public void youCannotAddOrRemoveHimFromAPremiumFlight() {
        assertAll("Verify all conditions for a usual passenger and a premium flight",
                () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                () -> assertEquals(0, premiumFlight.getPassengersList().size())
        );
    }

    @Then("you add or remove him from a premium flight")
    public void youAddOrRemoveHimFromAPremiumFlight() {
        assertAll("Verify all conditions for a VIP passenger and a premium flight",
                () -> assertEquals(true, premiumFlight.addPassenger(john)),
                () -> assertEquals(1, premiumFlight.getPassengersList().size()),
                () -> assertEquals(true, premiumFlight.removePassenger(john)),
                () -> assertEquals(0, premiumFlight.getPassengersList().size())
        );
    }

    //--------------------------------------------------------------------------------

    @And("you cannot add a usual passenger to an economy flight more than once")
    public void youCannotAddAUsualPassengerToAnEconomyFlightMoreThanOnce() {
    }
}
