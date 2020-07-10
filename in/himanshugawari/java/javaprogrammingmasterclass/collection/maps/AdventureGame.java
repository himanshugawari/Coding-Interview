package in.himanshugawari.java.javaprogrammingmasterclass.collection.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author himanshu
 *
 */
public class AdventureGame {
	private final static Scanner sc = new Scanner(System.in);

	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

	public static void main(String[] args) {

		locations.put(0, new Location(0, "You are sitting in front of your computer learning java"));
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
		locations.put(4, new Location(4, "You are in a valley beside a stream"));
		locations.put(5, new Location(5, "You are in a forest"));

		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);
//		locations.get(1).addExit("Q", 0);

		locations.get(2).addExit("N", 5);
//		locations.get(2).addExit("Q", 0);

		locations.get(3).addExit("W", 1);
//		locations.get(3).addExit("Q", 0);

		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);
//		locations.get(4).addExit("Q", 0);

		locations.get(5).addExit("S", 1);
		locations.get(5).addExit("W", 2);
//		locations.get(5).addExit("Q", 0);

		Map<String, String> vocabulary = new HashMap<String, String>();
		vocabulary.put("QUIT", "Q");
		vocabulary.put("NORTH", "N");
		vocabulary.put("SOUTH", "S");
		vocabulary.put("EAST", "E");
		vocabulary.put("WEST", "W");

		try {
			int loc = 1;// (int) (Math.random() * 6);
			while (true) {
				System.out.println(locations.get(loc).getDescription());
				if (loc == 0) {
					break;
				}
				Map<String, Integer> exits = locations.get(loc).getExits();
				System.out.print("Available exits are ");
				exits.keySet().forEach(exit -> System.out.print(exit + ", "));
				System.out.println();
				String direction = sc.nextLine().toUpperCase();
				if (direction.length() > 1) {
					String[] words = direction.split(" ");
					for (String word : words) {
						if (vocabulary.containsKey(word)) {
							direction = vocabulary.get(word);
							break;
						}
					}
				}
				if (exits.containsKey(direction)) {
					loc = exits.get(direction);
				} else {
					System.out.println("you cannot go in that direction");
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}
}

class Location {
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits;

	public Location(int locationId, String description) {
		super();
		this.locationId = locationId;
		this.description = description;
		this.exits = new HashMap<String, Integer>();
		this.exits.put("Q", 0);
	}

	public void addExit(String direction, int location) {
		exits.put(direction, location);
	}

	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {
		try {
			return new HashMap<String, Integer>(exits);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
