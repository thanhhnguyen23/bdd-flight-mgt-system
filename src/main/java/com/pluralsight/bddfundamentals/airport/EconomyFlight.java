package com.pluralsight.bddfundamentals.airport;

public class EconomyFlight extends Flight {

	public EconomyFlight(String id) {
		super(id);
	}

	@Override
	public boolean addPassenger(Passenger passenger) {
		return passengerSet.add(passenger);
	}

	@Override
	public boolean removePassenger(Passenger passenger) {
		if (!passenger.isVip()) {
			return passengerSet.remove(passenger);
		}
		return false;
	}

}
