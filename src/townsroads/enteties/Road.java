package townsroads.enteties;

public interface Road {

	String getRoadName();

	void setRoadName(String roadName);

	Town getOriginTown();

	void setOriginTown(Town originTown);

	Town getDestinationTown();

	void setDestinationTown(Town destinationTown);

	double getRoadLength();

	void setRoadLength(double roadLength);

}
