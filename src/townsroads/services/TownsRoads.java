package townsroads.services;

import java.util.Map;
import java.util.Set;

import townsroads.enteties.Road;
import townsroads.enteties.Town;

public interface TownsRoads {
	// Adding town
	boolean addTown(Town newTown);

	// Adding road
	boolean addRoad(Road newRoad);

	// Removing road
	boolean removeRoad(Town originTown, Town destinationTown);

	// Removing Town
	boolean removeTown(Town removeTown);

	// Getting roads
	Set<Road> getRoadsFrom(Town originTown);

	// * (additional) Getting destinations
	Map<Town, Double> getDestinationsFrom(Town originTown);

}
