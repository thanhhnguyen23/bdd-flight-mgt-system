package com.pluralsight.bddfundamentals.airport;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
                () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                () -> assertFalse(economyFlight.getPassengerSet().contains("Mike")),
                () -> assertEquals(true, economyFlight.removePassenger(mike)),
                () -> assertEquals(0, economyFlight.getPassengerSet().size())
        );
    }

    //--------------------------------------------------------------------------------

    @Then("you can add him but cannot remove him from an economy flight")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyFlight() {

        assertAll("Verify all conditions for a VIP passenger in an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(john)),
                () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                () -> assertTrue(economyFlight.getPassengerSet().contains(john)),
                () -> assertEquals(false, economyFlight.removePassenger(john)),
                () -> assertEquals(1, economyFlight.getPassengerSet().size())
        );
    }

    //--------------------------------------------------------------------------------

    @Then("you cannot add or remove him from a business flight")
    public void youCannotAddOrRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a usual passenger on a business flight",
                () -> assertEquals(false, businessFlight.addPassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengerSet().size()),
                () -> assertEquals(false, businessFlight.removePassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengerSet().size())
        );
    }

    @Then("you can add him but cannot remove him from a business flight")
    public void youCanAddHimButCannotRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a VIP passenger in a business flight",
                () -> assertEquals(true, businessFlight.addPassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengerSet().size()),
                () -> assertEquals(false, businessFlight.removePassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengerSet().size())
        );
    }

    //--------------------------------------------------------------------------------

    @Then("you cannot add or remove him from a premium flight")
    public void youCannotAddOrRemoveHimFromAPremiumFlight() {
        assertAll("Verify all conditions for a usual passenger and a premium flight",
                () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                () -> assertEquals(0, premiumFlight.getPassengerSet().size()),
                () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                () -> assertEquals(0, premiumFlight.getPassengerSet().size())
        );
    }

    @Then("you add or remove him from a premium flight")
    public void youAddOrRemoveHimFromAPremiumFlight() {
        assertAll("Verify all conditions for a VIP passenger and a premium flight",
                () -> assertEquals(true, premiumFlight.addPassenger(john)),
                () -> assertEquals(1, premiumFlight.getPassengerSet().size()),
                () -> assertEquals(true, premiumFlight.removePassenger(john)),
                () -> assertEquals(0, premiumFlight.getPassengerSet().size())
        );
    }

    //--------------------------------------------------------------------------------

    @And("you cannot add a usual passenger to an economy flight more than once")
    public void youCannotAddAUsualPassengerToAnEconomyFlightMoreThanOnce() {
        for(int i = 0; i < 10; i++){
            economyFlight.addPassenger(mike);
        }

        assertAll("Verify a usual passenger can be added to an economy flight only once",
                () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                () -> assertTrue(economyFlight.getPassengerSet().contains(mike)),
                () -> assertTrue(new ArrayList<>(economyFlight.getPassengerSet()).get(0).getName().equals("Mike"))
        );
    }

    @And("you cannot add a VIP passenger to an economy flight more than once")
    public void youCannotAddAVIPPassengerToAnEconomyFlightMoreThanOnce() {
        for(int i = 0; i < 10; i++){
            economyFlight.addPassenger(john);
        }

        assertAll("Verify a VIP passenger can be added to an economy flight once",
                () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                () -> assertTrue(economyFlight.getPassengerSet().contains(john)),
                () -> assertTrue(new ArrayList<>(economyFlight.getPassengerSet()).get(0).getName().equals("John"))
        );

    }

    @And("you cannot add a VIP passenger to a business flight more than once")
    public void youCannotAddAVIPPassengerToABusinessFlightMoreThanOnce() {
        for(int i = 0; i < 10; i ++){
            businessFlight.addPassenger(john);
        }

        assertAll("Verify a VIP passenger can be added to a business flight once",
                () -> assertEquals(1, businessFlight.getPassengerSet().size()),
                () -> assertTrue(businessFlight.getPassengerSet().contains(john)),
                () -> assertTrue(new ArrayList<>(businessFlight.getPassengerSet()).get(0).getName().equals("John"))
        );
    }

    @And("you cannot add a VIP passenger to a premium flight more than once")
    public void youCannotAddAVIPPassengerToAPremiumFlightMoreThanOnce() {
        for(int i = 0; i < 10; i ++){
            premiumFlight.addPassenger(john);
        }

        assertAll("Verify a VIP passenger can be added to a premium flight once",
                () -> assertEquals(1, premiumFlight.getPassengerSet().size()),
                () -> assertTrue(premiumFlight.getPassengerSet().contains(john)),
                () -> assertTrue(new ArrayList<>(premiumFlight.getPassengerSet()).get(0).getName().equals("John"))
        );
    }
}
