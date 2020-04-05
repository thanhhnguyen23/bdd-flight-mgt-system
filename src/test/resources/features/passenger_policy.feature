Feature: Passengers Policy
  The company follows a policy of adding and removing passengers, depending on the passenger type
  and on the flight type

  Scenario: Economy flight, usual passenger
    Given there is an economy flight
    When we have a usual passenger
    Then you can add and remove him from an economy flight
    And you cannot add a usual passenger to an economy flight more than once

  Scenario: Economy flight, VIP passenger
    Given there is an economy flight
    When we have a VIP passenger
    Then you can add him but cannot remove him from an economy flight

  Scenario: Business flight, usual passenger
    Given there is a business flight
    When we have a usual passenger
    Then you cannot add or remove him from a business flight

  Scenario: Business flight, VIP passenger
    Given there is a business flight
    When we have a VIP passenger
    Then you can add him but cannot remove him from a business flight

  Scenario: Premium flight, usual passenger
    Given there is a premium flight
    When we have a usual passenger
    Then you cannot add or remove him from a premium flight

  Scenario: Premium flight, VIP passenger
    Given there is a premium flight
    When we have a VIP passenger
    Then you add or remove him from a premium flight

