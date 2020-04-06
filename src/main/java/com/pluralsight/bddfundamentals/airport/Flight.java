package com.pluralsight.bddfundamentals.airport;

import java.util.*;

public abstract class Flight {

	private String id;
//	List<Passenger> passengersList = new ArrayList<Passenger>();
    Set<Passenger> passengerSet = new HashSet<>();

	public Flight(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

//	public List<Passenger> getPassengersList() {
//		return Collections.unmodifiableList(passengersList);
//	}
	public Set<Passenger> getPassengerSet() {
		return Collections.unmodifiableSet(passengerSet);
	}

	public abstract boolean addPassenger(Passenger passenger);

	public abstract boolean removePassenger(Passenger passenger);

}
