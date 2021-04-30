package townsroads.enteties.impl;

import townsroads.enteties.Road;
import townsroads.enteties.Town;

public class DefaultRoad implements Road {

	private String roadName;
	private Town originTown;
	private Town destinationTown;
	private double roadLength;

	public DefaultRoad(String roadName, Town firstTown, Town secondTown) {
		this.roadName = roadName;
		this.originTown = firstTown;
		this.destinationTown = secondTown;
	}

	public DefaultRoad(String roadName, Town originTown, Town destinationTown, double roadLength) {
		super();
		this.roadName = roadName;
		this.originTown = originTown;
		this.destinationTown = destinationTown;
		this.roadLength = roadLength;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public Town getOriginTown() {
		return originTown;
	}

	public void setOriginTown(Town originTown) {
		this.originTown = originTown;
	}

	public Town getDestinationTown() {
		return destinationTown;
	}

	public void setDestinationTown(Town destinationTown) {
		this.destinationTown = destinationTown;
	}

	public double getRoadLength() {
		return roadLength;
	}

	public void setRoadLength(double roadLength) {
		this.roadLength = roadLength;
	}

	@Override
	public String toString() {
		return "Road Name = " + roadName + ", Origin Town: " + originTown + ", Destination Town: " + destinationTown
				+ ", Road Length = " + roadLength;
	}

}