package townsroads.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import townsroads.enteties.Road;
import townsroads.enteties.Town;
import townsroads.services.TownsRoads;

public class DefaultTownsRoadsService implements TownsRoads {

	private List<Town> towns;
	private List<Road> roads;

	{
		towns = new ArrayList<Town>();
		roads = new ArrayList<Road>();
	}

	public List<Town> getTowns() {
		return towns;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public List<Road> getRoads() {
		return roads;
	}

	public void setRoads(List<Road> roads) {
		this.roads = roads;
	}

	@Override
	public boolean addTown(Town newTown) {
		if (newTown != null && isTownCoordinatesUnique(newTown)) {
			towns.add(newTown);
			return true;
		}
		return false;
	}

	@Override
	public boolean addRoad(Road newRoad) {
		if (newRoad != null && isRoadHasBothTowns(newRoad)) {
			roads.add(newRoad);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeRoad(Town originTown, Town destinationTown) {
		if (originTown != null && destinationTown != null) {
			for (Road road : roads) {
				if (road.getOriginTown().equals(originTown) && road.getDestinationTown().equals(destinationTown)) {
					roads.remove(road);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean removeTown(Town removeTown) {
		if (removeTown != null) {
			towns.remove(removeTown);
			return true;
		}
		return false;
	}

	@Override
	public Set<Road> getRoadsFrom(Town originTown) {
		Set<Road> listOfRoads = new HashSet<Road>();
		if (originTown != null) {
			for (Road road : roads) {
				if (road.getOriginTown().equals(originTown)) {
					listOfRoads.add(road);
				}
			}
		}
		return listOfRoads;
	}

	@Override
	public Map<Town, Double> getDestinationsFrom(Town originTown) {

//		if we use listOfRoads from Town class
//		if (originTown != null) {
//			Map<Town, Double> townDistance = new HashMap<Town, Double>();
//			for (Road road : originTown.getListOfRoads()) {
//				townDistance.put(road.getDestinationTown(), road.getRoadLength());
//			}
//			return townDistance;
//		}
//		return null;		

		Map<Town, Double> townDistance = new HashMap<Town, Double>();
		if (originTown != null) {
			for (Road road : roads) {
				if (road.getOriginTown().equals(originTown)) {
					townDistance.put(road.getDestinationTown(), road.getRoadLength());
				}
			}
			return townDistance;
		}
		return null;

	}

	public boolean isTownCoordinatesUnique(Town townForCheck) {
		if (towns != null) {
			for (Town town : towns) {
				if (town.getTownCoordinates() == townForCheck.getTownCoordinates()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isRoadHasBothTowns(Road road) {
		if (road != null) {
			return road.getOriginTown() != null && road.getDestinationTown() != null;
		}
		return false;
	}

}
