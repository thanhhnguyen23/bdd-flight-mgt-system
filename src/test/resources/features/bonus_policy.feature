Feature: Bonus Policy
  The company follows a bonus policy, depending on the passenger type and on the mileage

  Scenario Outline: Usual passenger bonus policy
    Given we have a usual passenger with a mileage
    When the usual passenger travels <mileage1> and <mileage2> and <mileage3>
    Then the bonus points of the usual passenger should be <points>

    Examples:
      | mileage1 | mileage2 | mileage3| points |
      |     349 |     319 |    623 |     64 |
