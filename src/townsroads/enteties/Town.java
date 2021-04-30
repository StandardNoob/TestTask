package townsroads.enteties;

import java.util.Set;

public interface Town {

	String getTownName();

	void setTownName(String townName);

	double getTownCoordinates();

	void setTownCoordinates(double townCoordinates);

	Set<Road> getListOfRoads();

	void setListOfRoads(Set<Road> listOfRoads);

	boolean equals(Town town);
}
