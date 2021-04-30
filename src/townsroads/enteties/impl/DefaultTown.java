package townsroads.enteties.impl;

import java.util.Set;
import townsroads.enteties.Road;
import townsroads.enteties.Town;

public class DefaultTown implements Town {

	private String townName;
	private double townCoordinates;
	private Set<Road> listOfRoads;

	public DefaultTown(String townName, double townCoordinates) {
		this.townName = townName;
		this.townCoordinates = townCoordinates;
	}

	public DefaultTown(String townName, double townCoordinates, Set<Road> listOfRoads) {
		this.townName = townName;
		this.townCoordinates = townCoordinates;
		this.listOfRoads = listOfRoads;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public double getTownCoordinates() {
		return townCoordinates;
	}

	public void setTownCoordinates(double townCoordinates) {
		this.townCoordinates = townCoordinates;
	}

	public Set<Road> getListOfRoads() {
		return listOfRoads;
	}

	public void setListOfRoads(Set<Road> listOfRoads) {
		this.listOfRoads = listOfRoads;
	}

	public boolean equals(Town town) {
		return this.townCoordinates == town.getTownCoordinates();
	}

	@Override
	public String toString() {
		return "Town Name = " + townName + ", Town Coordinates = " + townCoordinates;
	}
}
