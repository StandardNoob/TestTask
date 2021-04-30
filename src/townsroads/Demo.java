package townsroads;

import java.util.Map;

import townsroads.enteties.Road;
import townsroads.enteties.Town;
import townsroads.enteties.impl.DefaultRoad;
import townsroads.enteties.impl.DefaultTown;
import townsroads.services.impl.DefaultTownsRoadsService;

public class Demo {

	public static void main(String[] args) {

		Town town = new DefaultTown("Town", 000);
		Town town1 = new DefaultTown("Town1", 111);

		Town town2 = new DefaultTown("Town2", 222);
		Town town3 = new DefaultTown("Town3", 333);

		Road road = new DefaultRoad("Road", town, town1);
		Road road1 = new DefaultRoad("Road1", town2, town3);
		Road road2 = new DefaultRoad("Road2", town, town3, 100);

		DefaultTownsRoadsService defaultTownsRoadsService = new DefaultTownsRoadsService();

		defaultTownsRoadsService.addRoad(road);
		defaultTownsRoadsService.addRoad(road1);
		defaultTownsRoadsService.addRoad(road2);
		System.out.println("Added 3 roads:");
		defaultTownsRoadsService.getRoads().stream().forEach(System.out::println);

		System.out.println("Delete Road1:");
		defaultTownsRoadsService.removeRoad(road1.getOriginTown(), road1.getDestinationTown());
		defaultTownsRoadsService.getRoads().stream().forEach(System.out::println);

		System.out.println("Added 4 Towns:");
		defaultTownsRoadsService.addTown(town);
		defaultTownsRoadsService.addTown(town1);
		defaultTownsRoadsService.addTown(town2);
		defaultTownsRoadsService.addTown(town3);
		defaultTownsRoadsService.getTowns().stream().forEach(System.out::println);

		System.out.println("Delete Town3:");
		defaultTownsRoadsService.removeTown(town3);
		defaultTownsRoadsService.getTowns().stream().forEach(System.out::println);

		System.out.println("Get all roads from Town");
		defaultTownsRoadsService.getRoadsFrom(town).stream().forEach(System.out::println);

		System.out.println("Get Destinations From Town:");
		Map<Town, Double> map = defaultTownsRoadsService.getDestinationsFrom(town);

		for (Map.Entry<Town, Double> townDistance : map.entrySet()) {
			System.out.println(townDistance.getKey() + " - " + townDistance.getValue());
		}
	}
}
